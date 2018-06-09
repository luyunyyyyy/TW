import org.junit.Test;

import static domain.InputType.INVALID;
import static domain.InputType.NORMAL;
import static org.junit.Assert.assertEquals;

public class TestMain {
    @Test
    public void should_return_normal_format_when_the_input_legal() {

        assertEquals(NORMAL, Main.formatCheck("U001 2017-08-02 13:00~17:00 A"));
    }

    @Test
    public void should_return_invalid_format_when_the_date_illegal() {

        assertEquals(INVALID, Main.formatCheck("U001 2017-13-02 13:00~17:00 A"));
        assertEquals(INVALID, Main.formatCheck("U001 2017-13-02 13:00~17:00 A B"));
    }

}
