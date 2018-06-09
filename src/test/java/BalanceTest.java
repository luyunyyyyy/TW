import domain.Context;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static util.Util.dateToWeek;

public class BalanceTest {

    @Test
    public void testGetBalance() {
        Context context = new Context();
        Main.addBookingItem("U001 2017-01-01 18:00~20:00 A C", context);
        Main.addBookingItem("U001 2017-01-01 18:00~20:00 B", context);
        Main.addBookingItem("U001 2017-01-01 18:00~20:00 C", context);
        Main.addBookingItem("U001 2017-01-01 18:00~20:00 D", context);
        String result = Balance.getBalance(context);
        System.out.println(result);
    }

    @Test
    public void testSortGetBalacne() {
        Context context = new Context();
        Main.addBooking("U001 2017-01-01 18:00~20:00 A", context);
        Main.addBooking("U001 2017-01-01 11:00~12:00 A", context);
        Main.addBooking("U001 2017-01-01 12:00~13:00 A", context);
        Main.addBooking("U001 2017-01-01 13:00~14:00 A", context);
        CancelBooking.cancelBooking("U001 2017-01-01 18:00~20:00 A C", context);
        String result = Balance.getBalance(context);
        System.out.println(result);
    }

    @Test
    public void test() {
//        SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");
//        String currSun = dateFm.format(new Date("2018-06-09"));
//        System.out.println(currSun);
        assertEquals(dateToWeek("2017-01-01"), 7);
    }


}