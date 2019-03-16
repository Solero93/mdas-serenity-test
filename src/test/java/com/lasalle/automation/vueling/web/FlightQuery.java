package com.lasalle.automation.vueling.web;

import com.lasalle.automation.vueling.web.domain.FlightDate;

public class FlightQuery {
    private String origin;
    private String destination;
    private FlightDate outboundDate;
    private FlightDate returnDate;
    private Integer passengers;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public FlightDate getOutboundDate() {
        return outboundDate;
    }

    public void setOutboundDate(FlightDate outboundDate) {
        this.outboundDate = outboundDate;
    }

    public FlightDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(FlightDate returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getPassengers() {
        return passengers;
    }

    public void setPassengers(Integer passengers) {
        this.passengers = passengers;
    }
}
