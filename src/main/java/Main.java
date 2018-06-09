import domain.InputType;

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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String[] splitInputStrs = input.split(" ");
        if (splitInputStrs.length != 5) {
            return InputType.INVALID;
        }
        try {
            simpleDateFormat.setLenient(false);
            simpleDateFormat.parse(splitInputStrs[date]);
        } catch (ParseException e) {

            //e.printStackTrace();
            return InputType.INVALID;
        }
        return InputType.NORMAL;
    }

    public String addBooking(String input) {
        String[] splitInputStrs = input.split(" ");

        return null;
    }
}
