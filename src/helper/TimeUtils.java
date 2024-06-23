package helper;

import java.util.GregorianCalendar;

public class TimeUtils {
    public static boolean isLeapYear(int year) {
        return new GregorianCalendar().isLeapYear(year);
    }
}
