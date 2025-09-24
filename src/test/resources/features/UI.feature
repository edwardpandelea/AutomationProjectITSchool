Feature: UI Testing

  @UI @needLogin
  Scenario: Product page has all the required details
    Given I am on a product page
    Then I can see the title, image, description, add to cart button

  @UI @needLogin
  Scenario: Cart page has all the required details
    Given I add an item "Sauce Labs Backpack" to cart
    And I am on the cart page
    Then I can see the quantities, descriptions, prices, titles of the product "Sauce Labs Backpack"
