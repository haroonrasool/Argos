package com.mavenit.selenium.training;

import com.mavenit.selenium.training.driver.DriverFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class Hooks {

    private DriverFactory driverFactory = new DriverFactory();

    @Before
    public void setUp() {
        driverFactory.openBrowser();
        driverFactory.maxiBroser();
        driverFactory.applyImpWait();
    }

    @After
    public void tearDown() {
        driverFactory.closeBrowser();
    }
}
