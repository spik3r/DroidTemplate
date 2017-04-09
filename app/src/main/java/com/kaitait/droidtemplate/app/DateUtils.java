package com.kaitait.droidtemplate.app;

/**
 * Created by kai-tait on 7/04/2017.
 */

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public abstract class DateUtils {
    public static final DateTimeFormatter SHORT_DATE = DateTimeFormat.forPattern("yyyy-MM-dd/nHH:mm:ss");
    public static String format(DateTime dateTime) {
        return SHORT_DATE.print(dateTime);
    }
}
