@filters
Feature: Filters
  As an end user
  I want to filter the search results
  So that I can view refined products

  Scenario: Filter by Customer Rating
    Given I am on Homepage
    When I search for a product "nike"
    And I select a Customer Rating as "2or more"
    Then I should be able to see the product within the range of Customer Rating
