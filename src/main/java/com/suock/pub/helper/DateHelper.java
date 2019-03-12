package com.suock.pub.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {

    public static String formtDate(Date date, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }
}
