Feature: Checkout feature

  @CheckoutFlow @needLogin
  Scenario: A user is able to complete the checkout flow
    Given I am logged in and I can see the Home page
    When I add an item "Sauce Labs Bike Light" to cart
    And I go to cart
    And I click on "checkout" button
    And I enter first name "Max", last name "Payne" and zip code "077182"
    And I click on the "continue" button
    And I verify and then I click on "Finish" button to finalize the process
    And I see the checkout complete page with the success messages
    And I click on the "Back Home" button
    Then I am redirected to the home page

  @CheckoutFlow @needLogin
  Scenario: A user is not able to continue the checkout flow without entering first name, last name and zip code
    Given I am logged in and I can see the Home page
    When I add an item "Sauce Labs Bike Light" to cart
    And I go to cart
    And I click on "checkout" button
    And I click on the "continue" button
    Then I can't continue and get an error message that contans "{field} is required"

  @CheckoutFlow @needLogin
  Scenario: A user is able to cancel the checkout flow
    Given I am logged in and I can see the Home page
    When I add an item "Sauce Labs Bike Light" to cart
    And I go to cart
    And I click on "checkout" button
    And I click on "cancel" button
    Then I am redirected to the cart page