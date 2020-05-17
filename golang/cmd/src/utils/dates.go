// Package utils provide useful functions and utilities
// to process different types of data or perform different process
package utils

import "time"

// Dates is an useful struct that allow us
// to operate over dates and times.
type Dates struct{}

// IsGreatter returns if a date exceeds a limit.
// Obtain the date given minutes using the utils.Date{} GetDiffInMinutes method
// and copmare it with the limit given.
//
// The param date is the date to compare with the current date
// The param limit is the value that couldn't be exceeded
//
// Examples:
//		util.Dates{}.IsGreatter(time.Now().Add(time.Second * (-120)), 1)
//		  => true
//
//		util.Dates{}.IsGreatter(time.Now().Add(time.Second * +120), 1)
//        => false
//
// It returns true if the difference doesn't exceeds the limit, false otherwise
func (d Dates) IsGreatter(date time.Time, limit int32) bool {
	return d.GetDiffInMinutes(date) > limit
}

// GetDiffInMinutes returns the difference between two dates in terms of minutes
// It uses the utils.Date{} DiffInMinutes to operate in terms of minutes
//
// The param date is the date to compare with the current date
//
// Examples:
//		util.Dates{}.GetDiffInMinutes(time.Now().Add(time.Second * (-120)))
//		  => 2
//
//		util.Dates{}.GetDiffInMinutes(time.Now().Add(time.Second * 120))
//		  => -2
//
// It returns the difference between the current date and the given date
func (d Dates) GetDiffInMinutes(date time.Time) int32 {
	now := time.Now()
	return d.DiffInMinutes(date, now)
}

// DiffInMinutes returns the difference between two dates and parse the difference to minutes
//
// The param initial is the start date to compare
// The param final is the final date to compare
//
// Examples:
//		The operation performed is final_date - inital_date
//
//		util.Dates{}.DiffInMinutes(time.Now(), time.Now().Add(time.Second * 180)
//		  => 3
//
//		util.Dates{}.DiffInMinutes(time.Now().Add(time.Second * 180, time.Now())
//		  => -3
//
// It returns the difference between the given dates
func (d Dates) DiffInMinutes(initial time.Time, final time.Time) int32 {
	// Divide 1000000 to get milliseconds -> (A millisecond is 1_000_000 microseconds)
	// Divide 1000 to get seconds -> (a second is 1000 milliseconds)
	// Divide 60 to get minutes -> (a minute is 60 seconds)
	// Divide 60 to get hours -> (a hour is 60 minutes)
	// Divide 24 to get days -> (a day us 24 hours)
	return int32(int64(final.Sub(initial)) / 1000000 / 1000 / 60)
}
