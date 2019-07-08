package com.mavenit.selenium.training.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static WebDriver driver;

    private String browser = "";

    public DriverFactory() {
        PageFactory.initElements(driver,this);
    }

    public void openBrowser() {

        //write a switch to handle all the browsers

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.argos.co.uk/");
    }

    public void maxiBroser() {
        driver.manage().window().maximize();
    }

    public void applyImpWait() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void closeBrowser() {
        driver.quit();
    }
}
