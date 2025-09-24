Feature: Products sort

  @Sort @needLogin
  Scenario: From A to Z sort
    Given I am on the home page
    And I select the "Name (A to Z)" option from the sort select
    Then the products are sorted from "A to Z"

  @Sort @needLogin
  Scenario: From Z to A sort
    Given I am on the home page
    And I select the "Name (Z to A)" option from the sort select
    Then the products are sorted from "Z to A"

  @Sort @needLogin
  Scenario: Low to high price sort
    Given I am on the home page
    And I select the "Price (low to high)" option from the sort select
    Then the products are sorted "low to high"

  @Sort @needLogin
  Scenario: High to Low price sort
    Given I am on the home page
    And I select the "Price (high to low)" option from the sort select
    Then the products are sorted "high to low"