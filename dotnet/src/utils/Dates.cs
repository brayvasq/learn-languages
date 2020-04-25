using System;

namespace dotnet
{
    ///<summary>
    /// A util class to operate dates
    ///</summary>
    public class Dates{
        ///<summary>
        /// Returns if a date exceeds a limit.
        ///</summary>
        ///<param name="date">date to compare with the current date.</param>
        ///<param name="limit">difference limit in minutes between the dates.</param>
        ///<returns>
        /// true if the difference doesn't exceeds the limit
        ///</returns>
        public static bool IsGreatter(DateTime date, int limit){
            return Dates.GetDiffInMinutes(date) > limit;
        }

        ///<summary>
        /// Returns the difference between the current date and the given date.
        ///</summary>
        ///<param name="date">date to compare with the current date.</param>
        ///<returns>
        /// true if the difference doesn't exceeds the limit
        ///</returns>
        public static long GetDiffInMinutes(DateTime date){
            DateTime now = DateTime.Now;
            return Dates.DiffInMinutes(date, now);
        }

        ///<summary>
        /// Returns the difference between two dates.
        ///</summary>
        ///<param name="initalDate">Start date to compare.</param>
        ///<param name="finalDate">Final date to compare.</param>
        ///<returns>
        /// The difference between the given dates
        ///</returns>
        private static long DiffInMinutes(DateTime initialDate, DateTime finalDate){
            TimeSpan span = finalDate.Subtract ( initialDate );
            int minutes = span.Days * 24 * 60;
            minutes += span.Hours * 60;
            minutes += span.Minutes; //minutes
            return minutes;
        }
    }
}
