package com.lasalle.automation.vueling.web.page;

import net.serenitybdd.core.pages.PageObject;

public class FlightResultPage extends PageObject {
    public boolean areYouHere() {
        return this.getDriver().getCurrentUrl().equals("https://tickets.vueling.com/ScheduleSelect.aspx");
    }
}
