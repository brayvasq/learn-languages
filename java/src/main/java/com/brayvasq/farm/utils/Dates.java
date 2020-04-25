package com.brayvasq.farm.utils;

import java.util.Date;

/**
 * A util class to operate dates
 *
 * @author brayvasq
 */
public class Dates {

    /**
     * Returns if a date exceeds a limit
     *
     * @param date date to compare with the current date
     * @param limit difference limit in minutes between the dates
     * @return true if the difference doesn't exceeds the limit
     */
    public static boolean isGreatter(Date date, int limit) {
        return Dates.getDiffInMinutes(date) > limit;
    }

    /**
     * Returns the difference between the current date and the given date
     *
     * @param date date to compare with the current date
     * @return The difference between the current date and the given date
     */
    public static long getDiffInMinutes(Date date) {
        Date now = new Date();
        return Dates.diffInMinutes(now, date);
    }

    /**
     * Returns the difference between two dates
     *
     * @param initalDate Start date to compare
     * @param finalDate Final date to compare
     * @return The difference between the given dates
     */
    private static long diffInMinutes(Date initalDate, Date finalDate) {
        return (finalDate.getTime() - initalDate.getTime()) / (1000 * 60);
    }
}
