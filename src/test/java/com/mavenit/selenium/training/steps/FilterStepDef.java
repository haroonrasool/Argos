package com.mavenit.selenium.training.steps;

import com.mavenit.selenium.training.page_object_model.ResultsPage;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Every.everyItem;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class FilterStepDef {

    private ResultsPage resultsPage = new ResultsPage();

    @And("^I select a customer rating as \"([^\"]*)\"$")
    public void iSelectACustomerRatingAs(String userSelectedReview) {
        resultsPage.selectARating(userSelectedReview);
    }

    @Then("^I should be able to see product with in range of customer rating$")
    public void iShouldBeAbleToSeeProductWithInRangeOfCustomerRating() {
        List<Double> actualList = resultsPage.getCustomerRatingOnAllProducts();
        assertThat("List is storing wrong value or filter broken. ", actualList, everyItem(greaterThanOrEqualTo(2.0)));
    }
}
