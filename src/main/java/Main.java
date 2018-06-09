import domain.BookingItem;
import domain.Context;
import domain.InputType;
import domain.Strs;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {

    }

    public static InputType formatCheck(String input) {
        final int user = 0;
        final int date = 1;
        final int time = 2;
        final int site = 3;
        Context context = new Context();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String[] splitInputStrs = input.split(" ");
        if (splitInputStrs.length != 4) {
            return InputType.INVALID;
        }
        try {
            simpleDateFormat.setLenient(false);
            simpleDateFormat.parse(splitInputStrs[date]);
        } catch (ParseException e) {

            //e.printStackTrace();
            return InputType.INVALID;
        }
        if (!formatCheckTime(splitInputStrs[time], context.getSiteBeginTime(), context.getSiteEndTime())) {
            return InputType.INVALID;
        }

        if (!context.getSiteSet().contains(splitInputStrs[site])) {
            return InputType.INVALID;
        }

        return InputType.NORMAL;
    }


    public static boolean formatCheckTime(String input, int siteBeginTime, int siteEndTime) {
        if (input.length() != 11) {
            return false;
        }
        String[] inputSplit = input.split("[:~]");

        if (Integer.parseInt(inputSplit[0]) < siteBeginTime || Integer.parseInt(inputSplit[2]) > siteEndTime) {
            return false;
        }
        return Integer.parseInt(inputSplit[1]) == 0 && Integer.parseInt(inputSplit[3]) == 0;
    }


    public static String addBooking(String input, Context context) {
        if (formatCheck(input) != InputType.NORMAL) {
            return Strs.INVALID;
        }
        //Context context = new Context();
        BookingItem bookingItem = getBookingItemFromInput(input);
        if (isConflicts(bookingItem, context)) {
            return Strs.CONFLICTS;
        }
        addBookingItem(input, context);
        return Strs.NORMAL;
    }

    public static void addBookingItem(String input, Context context) {
//        final int user = 0;
//        final int date = 1;
//        final int time = 2;
//        final int site = 3;
//        String[] splitInputStrs = input.split(" ");
//        String[] inputSplit = splitInputStrs[time].split(":|~");
//        BookingItem bookingItem = new BookingItem(splitInputStrs[user],
//                (splitInputStrs[date]),
//                Integer.parseInt(inputSplit[0]),
//                Integer.parseInt(inputSplit[2]),
//                splitInputStrs[site]);
        context.getBookingItems().add(getBookingItemFromInput(input));
    }

    public static BookingItem getBookingItemFromInput(String input) {
        final int user = 0;
        final int date = 1;
        final int time = 2;
        final int site = 3;
        String[] splitInputStrs = input.split(" ");
        String[] inputSplit = splitInputStrs[time].split(":|~");
        BookingItem bookingItem = new BookingItem(splitInputStrs[user],
                (splitInputStrs[date]),
                Integer.parseInt(inputSplit[0]),
                Integer.parseInt(inputSplit[2]),
                splitInputStrs[site]);
        return bookingItem;
    }

    public static boolean isConflicts(BookingItem bookingItem, Context context) {
        for (BookingItem tempBookingItem : context.getBookingItems()) {
            if (tempBookingItem.getSiteId().equals(bookingItem.getSiteId()) &&
                    tempBookingItem.getBookingDate().equals(bookingItem.getBookingDate()) &&
                    !(bookingItem.getEndHour() <= tempBookingItem.getBeginHour()
                            || tempBookingItem.getEndHour() <= bookingItem.getBeginHour())) {
                return true;
            }
        }
        return false;
    }


}
