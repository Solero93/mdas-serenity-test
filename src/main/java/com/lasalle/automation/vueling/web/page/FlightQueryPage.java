package com.lasalle.automation.vueling.web.page;

import com.lasalle.automation.vueling.web.domain.FlightDate;
import com.lasalle.automation.vueling.web.domain.FlightQueryDto;
import com.lasalle.automation.vueling.web.domain.YearMonthDate;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class FlightQueryPage extends PageObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBys({
            @FindBy(css = "[vy-origin-selector]"),
            @FindBy(tagName = "input")
    })
    private WebElementFacade origin;

    @FindBy(css = ".liStation")
    private WebElementFacade originSuggestions;

    @FindBy(id = "inputGoing")
    private WebElementFacade originTime;

    @FindBys({
            @FindBy(css = "[vy-destination-selector]"),
            @FindBy(tagName = "input")
    })
    private WebElementFacade destination;

    @FindBy(css = ".liStation.connection-flight")
    private WebElementFacade destinationSuggestions;

    @FindBy(id = "btnSubmitHomeSearcher")
    private WebElementFacade submitQuery;

    public void navigate() {
        this.getDriver().manage().window().maximize();
        this.getDriver().get("https://www.vueling.com/es");
    }

    public void consultFlight(FlightQueryDto flightQuery) {
        LOGGER.debug("consultFlight starts, flightQuery: [{}]", flightQuery);

        selectOrigin(flightQuery.getOrigin());
        selectDestination(flightQuery.getDestination());

        submitQuery.click();
    }

    private void selectOrigin(String originPlace) {
        origin.click();
        origin.sendKeys(originPlace);
        originSuggestions.click();
    }

    private void selectDestination(String destinationPlace) {
        destination.click();
        destination.sendKeys(destinationPlace);
        destinationSuggestions.click();
    }

    private void selectDepartDate(String outBoundDate) {
        originTime.click();
        YearMonthDate departDate = FlightDate.valueOf(outBoundDate).getYearMonthDate();

        String dateSelector = String.format("[data-month=\"%s\"][data-year=\"%s\"]", departDate.getMonth(), departDate.getYear());
        WebElement originDate = this.getDriver()
                .findElement(By.cssSelector(dateSelector));
        originDate.click();
    }
}
