package com.lasalle.automation.vueling.web;

import com.lasalle.automation.vueling.web.domain.FlightQueryDto;
import com.lasalle.automation.vueling.web.page.FlightQueryPage;
import com.lasalle.automation.vueling.web.page.FlightResultPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class VuelingStepdefs {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static WebDriver driver;

    private FlightQueryPage flightQueryPage;
    private FlightResultPage flightResultPage;

    @Given("^I'm main page$")
    public void iMMainPage() {
        LOGGER.debug("navigate to main page");

        flightQueryPage.navigate();
    }

    @When("^I try to find a flight$")
    public void iTryToFindAFly(List<FlightQueryDto> flightQueries) {
        LOGGER.debug("start testFly");

        FlightQueryDto flightQuery = flightQueries.get(0);

        flightQueryPage.consultFlight(flightQuery);

    }

    @Then("^I get available flight$")
    public void iGetAvailableFlight() {
        LOGGER.debug("finish test");

        Assert.assertTrue(flightResultPage.areYouHere());
    }
}
