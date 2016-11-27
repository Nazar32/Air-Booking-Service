package Services;

import java.util.Date;
import java.util.GregorianCalendar;

public class DateGenerator {
    public static Date randomDate() {

        int year = randBetween(1900, 2016);
        int month = randBetween(0, 11);
        int hour = randBetween(9, 22);
        int min = randBetween(0, 59);
        int sec = randBetween(0, 59);


        GregorianCalendar gc = new GregorianCalendar(year, month, 1);
        int day = randBetween(1, gc.getActualMaximum(gc.DAY_OF_MONTH));

        gc.set(year, month, day, hour, min,sec);

        return gc.getTime();
    }

    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }

}
