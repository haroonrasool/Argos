@search
Feature: Search
  As an end user
  I want to search for a product
  So that I can view the respective product

  @smoke
  Scenario: Search for a product
    Given I am on Homepage
    When I search for a product "puma"
    Then I should be able to see the respective product

  @regression
  Scenario Outline: Search for a product
    Given I am on Homepage
    When I search for a "<product>"
    Then I should be able to see the respective product
    Examples:
      | product |
      | adidas  |
      | puma    |
      | nike    |
