import domain.BookingItem;
import domain.Context;
import domain.InputType;
import domain.Strs;

import static domain.Strs.INVALID;

public class CancelBooking {
    //public void
    public static String cancelBooking(String input, Context context) {

        /*
        缺少格式检验
         */
        if (Main.formatCheck(input.substring(0, input.length() - 2)) != InputType.NORMAL) {
            return INVALID;
        }
        if (context.getBookingItems().size() == 0) {
            return Strs.NOTEXISTS;
        }
        BookingItem bookingItem = Main.getBookingItemFromInput(input);
        bookingItem.setBreakBooking(true);
        for (BookingItem temp : context.getBookingItems()) {
            if (temp.equals(bookingItem)) {
                temp.setBreakBooking(true);
                context.getBreakBookingItems().add(bookingItem);
                context.getBookingItems().remove(temp);
                return Strs.NORMAL;
            }
        }
        return Strs.NOTEXISTS;
    }

}
