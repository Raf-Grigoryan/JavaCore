package homework.medicalCenter.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateUtil {
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public static Date stringToDate(String dateStr) throws ParseException {
        return simpleDateFormat.parse(dateStr);
    }
    public static String dateToString(Date date){
        return simpleDateFormat.format(date);
    }
}
