package com.lasalle.automation.vueling.web;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
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
import java.util.concurrent.TimeUnit;

public class VuelingTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "/Users/christiansoler/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        LOGGER.debug("driver started");
    }

    @AfterClass
    public static void afterClass() {
        driver.close();
        LOGGER.debug("driver closed");
    }

    @Test
    public void testTitle() throws InterruptedException {
        driver.get("https://www.vueling.com/es");
        LOGGER.debug("navigate to main page");

        LOGGER.debug("start testFly");

        WebElement origin = driver
                .findElement(By.cssSelector(".form-input.origin"))
                .findElement(By.cssSelector("input"));
        origin.click();
        origin.sendKeys("Almeria");

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
        destination.sendKeys("Alicante");

        List<WebElement> destinationSuggestions = driver
                .findElement(By.cssSelector(".form-input.destination"))
                .findElement(By.cssSelector("[vy-places]"))
                .findElements(By.cssSelector("li.liStation"));
        Assert.assertEquals(1, destinationSuggestions.size());
        destinationSuggestions.get(0).click();

        WebElement originTime = driver
                .findElement(By.cssSelector("[reflectinputid=\"inputGoing\"]"));
        originTime.click();

        Calendar cal = new GregorianCalendar();
        cal.add(Calendar.DAY_OF_MONTH, +7);

        String dateSelector = String.format("[data-month=\"%s\"][data-year=\"%s\"]", cal.get(Calendar.MONTH) + 1, cal.get(Calendar.YEAR));
        WebElement originDate = driver
                .findElement(By.cssSelector(dateSelector));
        originDate.click();

        WebElement submitFormButton = driver
                .findElement(By.id("btnSubmitHomeSearcher"));
        submitFormButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LOGGER.debug("finish testFly");
    }
}