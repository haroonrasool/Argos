package com.mavenit.selenium.training.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {
    public static WebDriver driver;

    public void OpenBrowser(String browserType, String url) {
        switch (browserType) {
            case "FireFox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "IE":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case "Safari":
                driver = new SafariDriver();
                break;
            default:
                System.out.println("browser : " +
                        browserType + " is invalid, Launching Firefox as browser of choice.");
                driver = new FirefoxDriver();
        }
        driver.get(url);
        driver.getTitle();
    }
}