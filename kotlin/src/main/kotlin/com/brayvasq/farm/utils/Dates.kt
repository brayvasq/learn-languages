package com.brayvasq.farm.utils

import java.util.*

/**
 * A util class to operate dates
 *
 * @author brayvasq
 */
class Dates {
    companion object {
        /**
         * Returns if a date exceeds a limit
         *
         * @param date date to compare with the current date
         * @param limit difference limit in minutes between the dates
         * @return true if the difference doesn't exceeds the limit
         */
        fun isGreatter(date : Date, limit : Int) : Boolean {
            return Dates.getDiffInMinutes(date) > limit
        }

        /**
         * Returns the difference between the current date and the given date
         *
         * @param date date to compare with the current date
         * @return The difference between the current date and the given date
         */
        fun getDiffInMinutes(date : Date) : Long{
            val now : Date = Date()
            return Dates.diffInMinutes(now, date)
        }

        /**
         * Returns the difference between two dates
         *
         * @param initalDate Start date to compare
         * @param finalDate Final date to compare
         * @return The difference between the given dates
         */
        fun diffInMinutes(initialDate : Date, finalDate : Date) : Long {
            return (finalDate.time - initialDate.time) / (1000 * 60);
        }
    }
}