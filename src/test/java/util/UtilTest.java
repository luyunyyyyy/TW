package util;

import org.junit.Test;

import static util.Util.dateToWeek;

public class UtilTest {

    @Test
    public void testDateToWeek() {
        System.out.println(dateToWeek("2018-06-09"));
    }
}