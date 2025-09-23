Feature: Cart flow

  @NoProduct
  Scenario: User unable to start checkout process without a product added to the cart
    Given I am on the cart page
    And I don't have an product added to cart
    Then I cannot start the checkout process

  @ExitCart
  Scenario: Cart page has all the required details
    Given I am on the cart page
    And I click on the "Continue shopping" button
    Then I am redirected to the home page

  @CartNumberUpdate
  Scenario: The cart icon indicates the number of products that the user adds
    Given I am on the home page
    When I click on the "Add to cart" button of a product
    Then the button changes to "Remove" and the cart icon changes adding the number of products added in the cart

  @AddProductToCart
  Scenario: User is able to add a product to cart
    Given I am on the home page
    When I click on the "Add to cart" button of the "Sauce Labs Bike Light"
    And I click on the cart button
    Then I can see the "Sauce Labs Bike Light" product in the cart page with the correct details

  @RemoveProductFromCart
  Scenario: User is able to remove a product to cart
    Given I am on the home page
    When I click on the cart button
    And I click on the "Remove" button of a product
    Then the product is removed from the cart