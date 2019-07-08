package com.mavenit.selenium.training.page_object_model;

import com.mavenit.selenium.training.driver.DriverFactory;
import com.mavenit.selenium.training.utils.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class ResultsPage extends DriverFactory {

    public void selectARating(String selected) {
        List<WebElement> ratingWebelements = driver.findElements(By.cssSelector(".ac-facet__filters--rating .ac-facet__label--rating"));
        for (WebElement ratingWebElement : ratingWebelements) {
            if (ratingWebElement.getText().equalsIgnoreCase(selected))
                ratingWebElement.click();
            break;
        }
    }

    public List<Double> getCustomerRatingOnAllProducts() {
        List<Double> collectedRatings = new ArrayList<Double>();
        List<WebElement> ratingWebelements = driver.findElements(By.cssSelector(".ac-star-rating"));
        for (WebElement ratingWebElement : ratingWebelements) {
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

        List<Double> collectedPriceList = new ArrayList<Double>();

        List<WebElement> priceWebelements = driver.findElements(By.cssSelector(".ac-product-price__amount"));
        for (WebElement priceWebElement : priceWebelements) {
            String priceInString = priceWebElement.getText().replace("£", "");
            double priceInDouble = Double.parseDouble(priceInString);
            collectedPriceList.add(priceInDouble);
        }
        return collectedPriceList;
    }

    public List<String> getProductNamesOnAllProducts() {
        List<String> collectedProductNamesList = new ArrayList<String>();

        List<WebElement> productNamesWebelements = driver.findElements(By.cssSelector(".ac-product-card__name"));
        for (WebElement productNamesElement : productNamesWebelements) {
            collectedProductNamesList.add(productNamesElement.getText());
        }
        return collectedProductNamesList;
    }

    public String selectAnyProducts() {
        List<WebElement> productNamesWebelements = driver.findElements(By.cssSelector(".ac-product-card__name"));
        int numberOfProducts = productNamesWebelements.size();
        int randomNumber = new Helpers().randomNumberGenerator(numberOfProducts);
        String selectedProduct=productNamesWebelements.get(randomNumber).getText();
        productNamesWebelements.get(randomNumber).click();
        return selectedProduct;
    }
}
