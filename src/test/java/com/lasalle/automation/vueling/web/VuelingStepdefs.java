package com.lasalle.automation.vueling.web;

import com.lasalle.automation.vueling.web.domain.FlightDate;
import com.lasalle.automation.vueling.web.domain.FlightQueryDto;
import com.lasalle.automation.vueling.web.domain.YearMonthDate;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class VuelingStepdefs {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static WebDriver driver;


    @Before
    public static void beforeScenario() {
        System.setProperty("webdriver.chrome.driver", "/Users/christiansoler/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        LOGGER.debug("driver started");
    }

    @After
    public static void afterScenario() {
        driver.close();
        LOGGER.debug("driver closed");
    }


    @Given("^I'm main page$")
    public void iMMainPage() {
        driver.get("https://www.vueling.com/es");
        LOGGER.debug("navigate to main page");
    }

    @When("^I try to find a flight$")
    public void iTryToFindAFly(List<FlightQueryDto> flightQueries) {
        LOGGER.debug("start testFly");

        FlightQueryDto flightQuery = flightQueries.get(0);

        WebElement origin = driver
            .findElement(By.cssSelector(".form-input.origin"))
            .findElement(By.cssSelector("input"));
        origin.click();
        origin.sendKeys(flightQuery.getOrigin());

        List<WebElement> originSuggestions = driver
            .findElement(By.cssSelector(".form-input.origin"))
            .findElement(By.cssSelector("[vy-places]"))
            .findElements(By.cssSelector("li.liStation"));
        Assert.assertEquals(1, originSuggestions.size());
        originSuggestions.get(0).click();

        WebElement destination = driver
                .findElement(By.cssSelector(".form-input.destination"))
                .findElement(By.cssSelector("input"));
        destination.click();
        destination.sendKeys(flightQuery.getDestination());

        List<WebElement> destinationSuggestions = driver
                .findElement(By.cssSelector(".form-input.destination"))
                .findElement(By.cssSelector("[vy-places]"))
                .findElements(By.cssSelector("li.liStation"));
        Assert.assertEquals(1, destinationSuggestions.size());
        destinationSuggestions.get(0).click();

        WebElement originTime = driver
                .findElement(By.cssSelector("[reflectinputid=\"inputGoing\"]"));
        originTime.click();

        YearMonthDate departDate = FlightDate.valueOf(flightQuery.getOutboundDate()).getYearMonthDate();

        String dateSelector = String.format("[data-month=\"%s\"][data-year=\"%s\"]", departDate.getMonth(), departDate.getYear());
        WebElement originDate = driver
                .findElement(By.cssSelector(dateSelector));
        originDate.click();

        WebElement submitButton = driver.findElement(By.id("btnSubmitHomeSearcher"));
        submitButton.click();

    }

    @Then("^I get available flight$")
    public void iGetAvailableFlight() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://tickets.vueling.com/ScheduleSelect.aspx");
    }
}
