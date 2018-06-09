import domain.BookingItem;
import domain.Context;

import java.util.ArrayList;
import java.util.TreeMap;

import static util.Util.rateOfCancel;

public class Balance {
    public static String getBalance(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("收入汇总\n---\n");
        TreeMap<String, ArrayList<BookingItem>> summaryMap = new TreeMap<>();
        for (BookingItem bookingItem : context.getBookingItems()) {
            if (summaryMap.get(bookingItem.getSiteId()) == null) {
                summaryMap.put(bookingItem.getSiteId(), new ArrayList<>());
                summaryMap.get(bookingItem.getSiteId()).add(bookingItem);
            } else {
                summaryMap.get(bookingItem.getSiteId()).add(bookingItem);
            }
        }
        for (BookingItem bookingItem : context.getBreakBookingItems()) {
            if (summaryMap.get(bookingItem.getSiteId()) == null) {
                summaryMap.put(bookingItem.getSiteId(), new ArrayList<>());
            } else {
                summaryMap.get(bookingItem.getSiteId()).add(bookingItem);
            }
        }
//        for(String key : summaryMap.keySet()){
//            Collections.sort(summaryMap.get(key));
//        }
        double allSummaryMoney = 0;
        double temp;
        for (String key : context.getSiteSet()) {
            double siteSummaryMoney = 0;
            stringBuilder.append("场地：" + key + "\n");
            // 这个数组没有排序
            for (BookingItem bookingItem : summaryMap.getOrDefault(key, new ArrayList<>())) {
                if (bookingItem.isBreakBooking()) {
                    temp = bookingItem.getMoneyOfBooking() * rateOfCancel(bookingItem.getBookingDate());
                    siteSummaryMoney += temp;
                    //System.out.println("违约金 比例" + rateOfCancel(bookingItem.getBookingDate()) + "订单金额 " + bookingItem.getMoneyOfBooking());
                    stringBuilder.append(bookingItem.getBookingDate() + " " + bookingItem.getBeginHour() + ":00~" +
                            bookingItem.getEndHour() + ":00 " + "违约金 " + temp + "元\n");
                } else {
                    temp = bookingItem.getMoneyOfBooking();
                    siteSummaryMoney += temp;
                    stringBuilder.append(bookingItem.getBookingDate() + " " + bookingItem.getBeginHour() + ":00~" +
                            bookingItem.getEndHour() + ":00 " +
                            "" + temp + "元\n");
                }
            }
            stringBuilder.append("小计: " + siteSummaryMoney + "元\n");
            allSummaryMoney += siteSummaryMoney;
        }
        stringBuilder.append("---\n总计：" + allSummaryMoney + "元\n");
        return stringBuilder.toString();
    }
}
