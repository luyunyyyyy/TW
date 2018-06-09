import domain.BookingItem;
import domain.Context;
import domain.InputType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        String[] inputSplit = input.split(":|~");

        if (Integer.parseInt(inputSplit[0]) < siteBeginTime || Integer.parseInt(inputSplit[2]) > siteEndTime) {
            return false;
        }
        return Integer.parseInt(inputSplit[1]) == 0 && Integer.parseInt(inputSplit[3]) == 0;
    }


    public String addBooking(String input) {
        String[] splitInputStrs = input.split(" ");

        return null;
    }

    public void addBookingItem(String input, Context context) {
        final int user = 0;
        final int date = 1;
        final int time = 2;
        final int site = 3;
        String[] splitInputStrs = input.split(" ");

        String[] inputSplit = input.split(":|~");
        BookingItem bookingItem = new BookingItem(splitInputStrs[user],
                new Date(splitInputStrs[date]),
                Integer.parseInt(inputSplit[0]),
                Integer.parseInt(inputSplit[2]),
                splitInputStrs[site]);
        context.getBookingItems().add(bookingItem);
    }
}
