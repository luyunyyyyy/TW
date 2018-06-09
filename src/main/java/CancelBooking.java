import domain.BookingItem;
import domain.Context;
import domain.Strs;

public class CancelBooking {
    //public void
    public static String cancelBooking(String input, Context context) {

        /*
        缺少格式检验
         */
        if (context.getBookingItems().size() == 0) {
            return Strs.NOTEXISTS;
        }
        BookingItem bookingItem = Main.getBookingItemFromInput(input);
        bookingItem.setBreakBooking(true);
        for (BookingItem temp : context.getBookingItems()) {
            if (temp.equals(bookingItem)) {
                temp.setBreakBooking(true);
                //TODO 删去原来数组中的item
                context.getBreakBookingItems().add(bookingItem);
                context.getBookingItems().remove(temp);
                return Strs.NORMAL;
            }
        }
        return Strs.NOTEXISTS;
    }

}
