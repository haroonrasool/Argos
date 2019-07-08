package com.mavenit.selenium.training.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.core.Every.everyItem;
import static org.hamcrest.core.IsEqual.equalTo;

public class SmokeTestSuite {

    WebDriver driver;

    @Before
    public void setUp() {
//      System.setProperty("webdriver.gecko.driver", "C:\\Users\\Haroon\\IdeaProjects\\Argos\\resources\\geckodriver.exe");
        WebDriverManager.firefoxdriver().setup();
        // Cross browser flexibility
        driver = new FirefoxDriver();
        driver.get("https://www.argos.co.uk/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //privacy pop up remover
        driver.findElement(By.cssSelector(".privacy-prompt-footer")).click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    //    @Test
    public void searchTest() {
        driver.findElement(By.id("searchTerm")).sendKeys("nike");
        driver.findElement(By.cssSelector(".ac-icon__search")).click();

        String actual = driver.findElement(By.id("")).getText();
        //hamcrest
        assertThat(actual, is(equalToIgnoringCase("nike")));
        //junit
        Assert.assertEquals(actual, "Nike");
    }

    @Test
    public void sample() {
        String something = "rk";
        assertThat(something, is(equalTo("RK")));
    }

    @Test
    public void reviewTest() {
        dosearch("nike");
        selectCustomerRating("4or more");
        List<Double> actualList = getAllRatingOnFilteredProduct();
        assertThat(actualList, everyItem(greaterThanOrEqualTo(4.0)));
    }

    public void dosearch(String item) {
        driver.findElement(By.id("searchTerm")).sendKeys(item);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    public List<Double> getAllRatingOnFilteredProduct() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Double> collectedRating = new ArrayList<>();

        List<WebElement> ratingWebelements = driver.
                findElements(By.cssSelector(".ac-star-rating"));

        for (WebElement ratingWebelement : ratingWebelements) {
            String ratingInString = ratingWebelement.getAttribute("data-star-rating");
            double ratingInDouble = Double.parseDouble(ratingInString);

            collectedRating.add(ratingInDouble);
//            double rating = Double.parseDouble(ratingWebelement.getAttribute("data-star-rating"));
        }

        return collectedRating;
    }

    public void selectCustomerRating(String customerSelectedRating) {

        List<WebElement> ratingWebElements = driver.findElements(By.
                cssSelector(".ac-facet__filters--rating .ac-facet__label--rating"));
        for (WebElement ratingWebElement : ratingWebElements) {
            if (ratingWebElement.getText().equalsIgnoreCase(customerSelectedRating)) {
                ratingWebElement.click();
                break;
            }
        }
    }
}
