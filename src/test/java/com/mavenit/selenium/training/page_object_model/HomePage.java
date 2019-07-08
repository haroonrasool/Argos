package com.mavenit.selenium.training.page_object_model;

import com.mavenit.selenium.training.driver.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends DriverFactory {

    public static String searchedProduct;

    @FindBy(id = "searchTerm")
    private WebElement searchTextBox;

    @FindBy(css = "button[type='submit']")
    private WebElement magnifierGlass;

    public void doSearch(String item) {
        searchedProduct = item;
        searchTextBox.sendKeys(item);
        magnifierGlass.click();
    }
    public String getHomePageUrl() {
        return driver.getCurrentUrl();
    }
}
