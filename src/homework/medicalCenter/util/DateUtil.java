package homework.medicalCenter.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateUtil {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private static final SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");

    public static Date stringToDate(String dateStr) throws ParseException {
        return dateFormat.parse(dateStr);
    }

    public static String dateToString(Date date) {
        return dateFormat.format(date);
    }

    public static Date stringToDateByTime(String date) throws ParseException {
        return dateTimeFormat.parse(date);
    }

    public static String dateTimeToString(Date date) {
        return dateTimeFormat.format(date);
    }
}
