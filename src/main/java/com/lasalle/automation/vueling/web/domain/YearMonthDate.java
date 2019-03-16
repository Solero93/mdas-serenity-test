package com.lasalle.automation.vueling.web.domain;

import java.util.Calendar;

public class YearMonthDate {
    private Integer year;
    private Integer month;

    public YearMonthDate(Calendar cal) {
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH) + 1;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getMonth() {
        return month;
    }
}
