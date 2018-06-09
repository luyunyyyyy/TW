import domain.BookingItem;
import domain.Context;
import domain.Strs;

public class CancelBooking {
    //public void
    public static String cancelBooking(String input, Context context) {

        if (context.getBookingItems().size() == 0) {
            return Strs.NOTEXISTS;
        }
        BookingItem bookingItem = Main.getBookingItemFromInput(input);
        bookingItem.setBreakBooking(true);
        for (BookingItem temp : context.getBookingItems()) {
            if (temp.equals(bookingItem)) {
                return Strs.NORMAL;
            }
        }
        return Strs.NOTEXISTS;
    }

}
