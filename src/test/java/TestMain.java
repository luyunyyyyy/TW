import domain.Context;
import domain.InputType;
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

}
