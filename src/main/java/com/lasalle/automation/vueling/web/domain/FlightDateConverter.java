package com.lasalle.automation.vueling.web.domain;

import cucumber.deps.com.thoughtworks.xstream.converters.basic.StringConverter;

public class FlightDateConverter extends StringConverter {
    public Object fromString(String flightDate) {
        return flightDate.isEmpty() ? null : FlightDate.valueOf(flightDate).getYearMonthDate();
    }
}
