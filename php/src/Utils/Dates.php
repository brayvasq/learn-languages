<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

namespace App;

/**
 * A util class to operate dates
 *
 * @author brayvasq
 */
class Dates {
    /**
     * Returns if a date exceeds a limit
     *
     * @param date date to compare with the current date
     * @param limit difference limit in minutes between the dates
     * @return true if the difference doesn't exceeds the limit
     */
    public function isGreatter($date, $limit){
        return Dates::getDiffInMinutes($date) > $limit;
    }

    /**
     * Returns the difference between the current date and the given date
     *
     * @param date date to compare with the current date
     * @return The difference between the current date and the given date
     */
    public static function getDiffInMinutes($date){
        $now = new \DateTime();
        return Dates::diffInMinutes($now, $date);
    }

    /**
     * Returns the difference between two dates
     *
     * @param initalDate Start date to compare
     * @param finalDate Final date to compare
     * @return The difference between the given dates
     */
    public static function diffInMinutes($initalDate, $finalDate) {
        $since_start = $initalDate->diff($finalDate);
        $minutes = $since_start->days * 24 * 60;
        $minutes += $since_start->h * 60;
        $minutes += $since_start->i; //minutes
        return $minutes;
    }
}

?>
