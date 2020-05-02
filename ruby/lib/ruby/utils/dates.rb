# A util class to operate dates
module Dates
    # Returns if a date exceeds a limit
    #
    # @param date [Time] date to compare with the current date
    # @param limit [Integer] difference limit in minutes between the dates
    #
    # Examples:
    #   Dates.is_greatter(Time.now - 120, 1)
    #     => true
    #
    #   Dates.is_greatter(Time.now + 120, 1)
    #     => false
    #
    # @return [Boolean] true if the difference doesn't exceeds the limit
    def self.is_greatter(date, limit)
        return self.get_diff_in_minutes(date) > limit
    end

    # Returns the difference between the current date and the given date
    #
    # @param date [Time] date to compare with the current date
    #
    # Examples:
    #   Dates.get_diff_in_minutes(Time.now - 120)
    #     => 2.00000006625
    #
    #   Dates.get_diff_in_minutes(Time.now + 120)
    #     => -1.9999999124
    #
    # @return [Float] The difference between the current date and the given date
    def self.get_diff_in_minutes(date)
        now = Time.now
        return self.diff_in_minutes(date, now)
    end

    private
    # Returns the difference between two dates
    #
    # @param inital_date [Time] Start date to compare
    # @param final_date [Time] Final date to compare
    #
    # Examples:
    #   The operation performed is final_date - inital_date
    #
    #   diff_in_minutes(Time.now, Time.now + 180)
    #     => 3.0000000196166665
    #
    #   diff_in_minutes(Time.now + 180, Time.now)
    #     => -2.9999999579166663
    #
    # @return [Float] The difference between the given dates
    def self.diff_in_minutes(init_date, final_date)
        return (final_date - init_date) / 60
    end
end
