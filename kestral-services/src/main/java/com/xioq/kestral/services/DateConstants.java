package com.xioq.kestral.services;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by bronwen.cassidy on 15/04/2015.
 * Date DateConstants file
 */
public class DateConstants {

    public static final String UTC_DATE_FORMAT = "yyyy-MM-dd";
    public static final String UTC_TIME_FORMAT = "HH:mm";
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern(UTC_DATE_FORMAT);
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormat.forPattern(UTC_TIME_FORMAT);
}
