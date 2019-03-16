package com.lasalle.automation.vueling.web.domain;

public class FlightQueryDto {
    private String origin;
    private String destination;
    private String outboundDate;
    private String returnDate;
    private String passengers;

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

    public String getOutboundDate() {
        return outboundDate;
    }

    public void setOutboundDate(String outboundDate) {
        this.outboundDate = outboundDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }
}
