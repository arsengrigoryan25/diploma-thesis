package com.warehouse.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateUtils {

    public static Date setDateStartOrEndTime(Date date, boolean startTime) {
        if (date == null) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (startTime) {
            calendar.set(Calendar.AM_PM, Calendar.AM);
            calendar.set(Calendar.HOUR, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
        } else {
            calendar.set(Calendar.AM_PM, Calendar.PM);
            calendar.set(Calendar.HOUR, 11);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
            calendar.set(Calendar.MILLISECOND, 999);
        }

        return calendar.getTime();
    }

    public static Date dateAddNowTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        Calendar dateCal = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));

        if (cal.getTimeInMillis() == dateCal.getTimeInMillis()) {
            Calendar nowCal = new GregorianCalendar();
            cal.set(Calendar.HOUR_OF_DAY, nowCal.get(Calendar.HOUR_OF_DAY));
            cal.set(Calendar.MINUTE, nowCal.get(Calendar.MINUTE));
            cal.set(Calendar.SECOND, nowCal.get(Calendar.SECOND));
            cal.set(Calendar.MILLISECOND, nowCal.get(Calendar.MILLISECOND));
            date = cal.getTime();
        }
        return date;
    }

    public static Date stringToDate(String strDate, String pattern) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.getDefault());
        format.setLenient(false);

        return format.parse(strDate);
    }

    public static String dateToString(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    public static Date addDays(Date date, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, amount);
        return cal.getTime();
    }

    /**
     * Returns next month's first day date of the specified period.
     *
     *
     * @param year
     * @param period: 01 - 12 for months; 21 - 24 for quarters; 00 for year
     * @return
     */
    public static Date getPeriodNextDate(int year, String period) {
        char periodKey = period.charAt(0);
        int month = 0;

        if (period.equals("00")) {
            month = 12;
        } else if (periodKey == '2') {
            int quarter = Integer.parseInt(period.substring(1));
            month = 3 * quarter;
        } else {
            month = Integer.parseInt(period);
        }
        if (month == 12) {
            month = 0;
            ++year;
        }

        return new GregorianCalendar(year, month, 1).getTime();
    }

    public static Date stringToDateMy(String stringDate, String dateFormat){
        Date date = null;
        if (stringDate != null && !stringDate.trim().isEmpty()) {
            try {
                date = new SimpleDateFormat(dateFormat).parse(stringDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return date;
    }


}
