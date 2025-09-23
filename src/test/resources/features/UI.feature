Feature: UI Testing

  @ProductPage
  Scenario: Product page has all the required details
    Given I am on a product page
    Then I can see the title, image, description, add to cart button

  @CartPage
  Scenario: Cart page has all the required details
    Given I am on the cart page
    Then I can see the quantities, descriptions, prices, titles of all the products from the cart

  @MenuUI
  Scenario: The menu has all the buttons
    Given I am on the home page
    When I click on the menu button
    Then I can see the menu with the following buttons: "All items, About, Logout, Reset App State"