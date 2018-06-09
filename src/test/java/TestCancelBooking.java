import domain.Context;
import domain.Strs;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCancelBooking {
    @Test
    public void should_return_normal_when_cancel_booking() {
        Context context = new Context();
        Main.addBooking("U001 2017-01-01 20:00~22:00 A", context);
        assertEquals(Strs.NORMAL, CancelBooking.cancelBooking("U001 2017-01-01 20:00~22:00 A C", context));
    }

    @Test
    public void should_return_notexists_when_cancel_not_exist_booking() {
        Context context = new Context();
        assertEquals(Strs.NOTEXISTS, CancelBooking.cancelBooking("U001 2017-01-01 20:00~22:00 A C", context));

        context = new Context();
        Main.addBooking("U001 2017-01-01 20:00~21:00 A", context);
        assertEquals(Strs.NOTEXISTS, CancelBooking.cancelBooking("U001 2017-01-01 20:00~22:00 A C", context));

        context = new Context();
        Main.addBooking("U001 2017-01-01 19:00~21:00 A", context);
        assertEquals(Strs.NOTEXISTS, CancelBooking.cancelBooking("U001 2017-01-01 20:00~21:00 A C", context));

    }

}
