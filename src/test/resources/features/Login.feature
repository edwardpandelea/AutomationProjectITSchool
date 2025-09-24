Feature: Login Flow

  @Login
  Scenario: Valid Login
    Given I am on the login page
    When I log in with username and password
    Then I should be redirected to the home page

  @Login
  Scenario: Invalid Login
    Given I am on the login page
    When I try to log in with wrong username and password
    Then I should see the error message: "Epic sadface: Username and password do not match any user in this service"

  @Logout @needLogin
  Scenario: Logout
    Given I am on the home page already logged in
    When I click the menu button
    And I click the logout button
    Then I should be redirected to the login page