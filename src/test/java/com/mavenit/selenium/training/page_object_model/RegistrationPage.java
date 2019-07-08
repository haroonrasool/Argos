package com.mavenit.selenium.training.page_object_model;

import com.mavenit.selenium.training.driver.DriverFactory;
import com.mavenit.selenium.training.utils.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RegistrationPage extends DriverFactory {

    public static String expectedCustomerRating;

    @FindBy(css = ".ac-facet__filters--rating .ac-facet__label--rating")
    private List<WebElement> customerRatings;

    @FindBy(css = ".ac-star-rating")
    private List<WebElement> ratingWebElemenntAttributes;

    public void selectARating(String selected) {
        for (WebElement ratinngWebElemnet : customerRatings) {
            if (ratinngWebElemnet.getText().equalsIgnoreCase(selected))
                expectedCustomerRating = selected;
            ratinngWebElemnet.click();
            break;
        }
    }

    public List<Double> getCustomerRatingOnAllProducts() {
        List<Double> collectedRatings = new ArrayList<Double>();
//        List<WebElement> ratingWebelements = driver.findElements(By.cssSelector(".ac-star-rating"));
        for (WebElement ratingWebElement : ratingWebElemenntAttributes) {
            String stringValue = ratingWebElement.getAttribute("data-star-rating");
            double valueInDouble = Double.parseDouble(stringValue);
            collectedRatings.add(valueInDouble);
        }

        return collectedRatings;
    }

    public void selectAFilterByCheckBox(String myChoice) {
        List<WebElement> filterWebelements = driver.findElements(By.cssSelector(".ac-facet__filter.ac-facet__filter--default"));
        for (WebElement filterWebelement : filterWebelements) {
            if (filterWebelement.getText().equalsIgnoreCase(myChoice)) {
                filterWebelement.click();
                break;
            }
        }
    }

    public List<Double> getPricesOnAllProducts() {

        List<Double> collectedPriceList = new ArrayList<>();

        List<WebElement> priceWebelements = driver.findElements(By.cssSelector(".ac-product-price__amount"));
        for (WebElement priceWebElement : priceWebelements) {
            String priceInString = priceWebElement.getText().replace("£", "");
            double priceInDouble = Double.parseDouble(priceInString);
            collectedPriceList.add(priceInDouble);
        }
        return collectedPriceList;
    }

    public List<String> getProductNamesOnAllProducts() {
        List<String> collectedProductNamesList = new ArrayList<>();

        List<WebElement> productNamesWebelements = driver.findElements(By.cssSelector(".ac-product-card__name"));
        for (WebElement productNamesElement : productNamesWebelements) {
            collectedProductNamesList.add(productNamesElement.getText());
        }
        return collectedProductNamesList;
    }

    public String selectAnyProducts() {
        List<WebElement> productNamesWebelements = driver.findElements(By.cssSelector(""));
        int numberOfProducts = productNamesWebelements.size();
        int randomNumber = new Helpers().randomNumberGenerator(numberOfProducts);
        String selectedProduct = productNamesWebelements.get(randomNumber).getText();
        productNamesWebelements.get(randomNumber).click();
        return selectedProduct;
    }

    public String getProductHeader() {
        return driver.findElement(By.cssSelector(".search-title__term")).getText();
    }
}