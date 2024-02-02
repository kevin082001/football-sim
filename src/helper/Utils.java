package helper;

import java.util.GregorianCalendar;

public class Utils {
    public static boolean isLeapYear(int year) {
        return new GregorianCalendar().isLeapYear(year);
    }
}
