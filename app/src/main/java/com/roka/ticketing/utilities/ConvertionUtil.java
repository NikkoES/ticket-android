package com.roka.ticketing.utilities;

import android.os.Build;
import android.text.format.DateUtils;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

/**
 * Created by roka on 16/03/18.
 */

public class ConvertionUtil {

    private static final String ISODATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    public static Date fromISOString(String inputDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(ISODATE_PATTERN, Locale.US);
            format.setCalendar(new GregorianCalendar(new SimpleTimeZone(0, "GMT")));
            if(inputDate == null) return format.parse(new Date().toString());

            return format.parse(inputDate);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String toISOString(Date inputDate) {
        SimpleDateFormat format = new SimpleDateFormat(ISODATE_PATTERN, Locale.US);
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        return format.format(inputDate);
    }

    public static String toGeneralString(Date inputDate) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            format = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);
        }

        return format.format(inputDate);
    }

    public static Date toDateFromGeneralString(String inputDate) {
        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy", Locale.US);
        format.setTimeZone(TimeZone.getTimeZone("Asia/Jakarta"));

        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(format.parse(inputDate));
            calendar.add(Calendar.HOUR, 12);

            return calendar.getTime();
        } catch (ParseException e) {
            Log.d("DATE", e.toString());
            return null;
        }
    }

    public static String toShortString(Date inputDate) {
        SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy", Locale.US);

        Calendar inputDateCalendar = Calendar.getInstance();
        Calendar currentDateCalendar = Calendar.getInstance();

        inputDateCalendar.setTime(inputDate);
        currentDateCalendar.setTime(new Date());

        currentDateCalendar.get(Calendar.YEAR);
        if(inputDateCalendar.get(Calendar.YEAR) == currentDateCalendar.get(Calendar.YEAR)) {
            format = new SimpleDateFormat("dd MMM", Locale.US);
        }

        return format.format(inputDate);
    }

    public static String getTimeAgo(Date inputDate) {
        String timestamp = "";
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

        /*
            Check if it is today
         */
        if(DateUtils.isToday(inputDate.getTime())) {
            timestamp = DateUtils.getRelativeTimeSpanString(
                    inputDate.getTime(),
                    new Date().getTime(),
                    DateUtils.DAY_IN_MILLIS).toString()
                    +", " + timeFormat.format(inputDate);
        }
        /*
            Not today
         */
        else {
            Calendar currentCalendar = Calendar.getInstance();
            Calendar dateCalendar = Calendar.getInstance();

            currentCalendar.setTime(new Date());
            dateCalendar.setTime(inputDate);


            /*
                Check if it is yesterday
             */
            if(currentCalendar.get(Calendar.DATE) - dateCalendar.get(Calendar.DATE) == 1) {
                timestamp = DateUtils.getRelativeTimeSpanString(
                        inputDate.getTime(),
                        new Date().getTime(),
                        DateUtils.DAY_IN_MILLIS).toString()
                        +", " + timeFormat.format(inputDate);

                return timestamp;
            }

            /*
                Check if it is in the same year
             */
            if(currentCalendar.get(Calendar.YEAR) == dateCalendar.get(Calendar.YEAR)) {
                SimpleDateFormat sameYearFormat = new SimpleDateFormat("dd MMM, HH:mm", Locale.US);
                return sameYearFormat.format(inputDate);
            }
            /*
                Not in the same year
             */
            else {
                timestamp = DateUtils.getRelativeTimeSpanString(
                        inputDate.getTime(),
                        new Date().getTime(),
                        DateUtils.DAY_IN_MILLIS).toString()
                        +", " + timeFormat.format(inputDate);
            }
        }

        return timestamp;
    }

    private ConvertionUtil() { }
}