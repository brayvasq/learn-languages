import datetime

class Dates:
    """
    A util class to operate dates

    ...
    Methods
    -------
    @staticmethod\n
    is_greatter(date, limit)
        Returns if a date exceeds a limit

    @staticmethod\n
    get_diff_in_minutes(date)
        Returns the difference between current date and another

    @staticmethod\n
    __diff_in_minutes(date)
        Returns the difference in minutes between two dates
    """

    @staticmethod
    def is_greatter(date, limit : int):
        """
        Returns if a date exceeds a limit

        Parameters
        ----------
        date : datetime
            date to compare with the current date

        limit : int
            difference limit in minutes between the dates

        Return
        ------
        True if the difference doesn't exceeds the limit\n
        False otherwise
        """
        return Dates.get_diff_in_minutes(date) > limit

    @staticmethod
    def get_diff_in_minutes(date):
        """
        Returns the difference between the current date and the given date

        Parameters
        ----------
        date : datetime
            date to compare with the current date

        Return
        ------
        diff : int
            The difference between the current date and the given date
        """
        now = datetime.datetime.now()
        return Dates.__diff_in_minutes(now, date)

    @staticmethod
    def __diff_in_minutes(init_date, final_date):
        """
        Returns the difference between two dates

        Parameters
        ----------
        init_date : datetime
            Start date to compare
        final_date : datetime
            Final date to compare

        Return
        ------
        diff : int
            The difference between the given dates
        """
        return abs((init_date - final_date).total_seconds() / 60)
