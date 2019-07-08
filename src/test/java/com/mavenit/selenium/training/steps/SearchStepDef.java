package com.mavenit.selenium.training.steps;

import com.mavenit.selenium.training.page_object_model.HomePage;
import com.mavenit.selenium.training.page_object_model.ResultsPage;
import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.hamcrest.Matchers.is;

public class SearchStepDef {
    private HomePage homePage = new HomePage();
    private ResultsPage resultsPage = new ResultsPage();

    @Given("^I am on Homepage$")
    public void i_am_on_Homepage() {
        String actual = homePage.getHomePageUrl();
        assertThat("HomePage might be end with something or user on different page .", actual, Matchers.endsWith("co.uk/"));
    }


    @When("^I search for a product \"([^\"]*)\"$")
    public void iSearchForAProduct(String searchItem) {
        homePage.doSearch(searchItem);
    }

    @Then("^I should be able to see the respective product")
    public void i_should_be_able_to_see_the_respective_product() {
        String actual = resultsPage.getProductHeader();
        assertThat("you got some different product. ", actual, is(equalToIgnoringWhiteSpace(HomePage.searchedProduct)));
    }

    @When("^I search for a \"([^\"]*)\"$")
    public void i_search_for_a(String item) {
        homePage.doSearch(item);
    }
}
