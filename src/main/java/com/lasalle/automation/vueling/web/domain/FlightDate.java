package com.lasalle.automation.vueling.web.domain;

import java.util.Calendar;
import java.util.GregorianCalendar;

public enum FlightDate {

    NEXT_WEEK {
        public YearMonthDate getYearMonthDate() {
            Calendar cal = new GregorianCalendar();
            cal.add(Calendar.DAY_OF_MONTH, +7);
            return new YearMonthDate(cal);
        }
    };

    public abstract YearMonthDate getYearMonthDate();
}
