import domain.BookingItem;
import domain.Context;
import domain.InputType;
import domain.Strs;
import org.junit.Test;

import static domain.InputType.INVALID;
import static domain.InputType.NORMAL;
import static org.junit.Assert.assertEquals;

public class TestMain {
    private static void test_format_util(InputType expect, String input) {
        Context context = new Context();
        //assertEquals(expect, Main.formatCheck(input, context));
    }

    @Test
    public void should_return_normal_format_when_the_input_legal() {
        Context context = new Context();
        assertEquals(NORMAL, Main.formatCheck("U001 2017-08-02 13:00~17:00 A"));
    }

    @Test
    public void should_return_invalid_format_when_the_date_illegal() {

        assertEquals(INVALID, Main.formatCheck("U001 2017-13-02 13:00~17:00 A"));
        assertEquals(INVALID, Main.formatCheck("U001 2017-12-02 13:00~17:00 A B"));


    }

    @Test
    public void should_return_invalid_format_when_the_time_illegal() {
        assertEquals(INVALID, Main.formatCheck("U001 2017-01-01 08:00~10:00 A"));
        assertEquals(INVALID, Main.formatCheck("U001 2017-01-01 20:00~23:00 A"));
        assertEquals(INVALID, Main.formatCheck("U001 2017-01-01 08:00~23:00 A"));
        assertEquals(INVALID, Main.formatCheck("U001 2017-01-01 09:30~10:00 A"));
        assertEquals(INVALID, Main.formatCheck("U001 2017-01-01 10:00~10:30 A"));
        assertEquals(INVALID, Main.formatCheck("U001 2017-01-01 9:00~10:00 A"));
        assertEquals(INVALID, Main.formatCheck("U001 2017-01-01 8:00~9:00 A"));
    }

    @Test
    public void should_return_invalid_format_when_the_site_illegal() {
        assertEquals(INVALID, Main.formatCheck("U001 2017-01-01 20:00~22:00 E"));
        assertEquals(INVALID, Main.formatCheck("U001 2017-01-01 20:00~22:00 AC"));
        assertEquals(NORMAL, Main.formatCheck("U001 2017-01-01 20:00~22:00 A"));
    }

    @Test
    public void add_item() {
        Context context = new Context();
        Main.addBookingItem("U001 2017-01-01 20:00~22:00 A", context);
        assertEquals(context.getBookingItems().get(0).getUserId(), "U001");
        assertEquals(context.getBookingItems().get(0).getBookingDate(), "2017-01-01");
        assertEquals(context.getBookingItems().get(0).getBeginHour(), 20);
        assertEquals(context.getBookingItems().get(0).getEndHour(), 22);
        assertEquals(context.getBookingItems().get(0).getSiteId(), "A");
    }

    @Test
    public void should_return_conflicts_when_the_booking_existing() {
        Context context = new Context();
        Main.addBookingItem("U001 2017-01-01 18:00~20:00 A", context);

        BookingItem item = Main.getBookingItemFromInput("U001 2017-01-01 17:00~19:00 A");
        assertEquals(true, Main.isConflicts(item, context));

        BookingItem item1 = Main.getBookingItemFromInput("U001 2017-01-01 19:00~21:00 A");
        assertEquals(true, Main.isConflicts(item1, context));

        BookingItem item2 = Main.getBookingItemFromInput("U001 2017-01-01 17:00~21:00 A");
        assertEquals(true, Main.isConflicts(item2, context));
    }

    @Test
    public void should_return_none_conflicts_when_the_booking_not_existing() {
        Context context = new Context();
        Main.addBookingItem("U001 2017-01-01 20:00~22:00 A", context);

        BookingItem item = Main.getBookingItemFromInput("U001 2017-01-01 19:00~20:00 A");
        assertEquals(false, Main.isConflicts(item, context));
    }


    @Test
    public void should_return_str_normal_when_the_booking_not_existing() {
        Context context = new Context();
        assertEquals(Strs.NORMAL, Main.addBooking("U001 2017-01-01 20:00~22:00 A", context));
    }

    @Test
    public void should_return_str_invalid_when_the_booking_not_existing() {
        Context context = new Context();
        assertEquals(Strs.INVALID, Main.addBooking("U001 2017-01-01 20:00~22:0000000 A", context));
    }

    @Test
    public void should_return_str_conflicts_when_the_booking_existing() {
        Context context = new Context();
        assertEquals(Strs.NORMAL, Main.addBooking("U001 2017-01-01 20:00~22:00 A", context));
        assertEquals(Strs.CONFLICTS, Main.addBooking("U001 2017-01-01 20:00~21:00 A", context));
    }
}
