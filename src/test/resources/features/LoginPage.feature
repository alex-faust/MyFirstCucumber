@tagLogin
Feature: LoginPage feature

  Scenario: Verify LoginPage loaded
    Given I open the Home Page
    Then  I click on the login link
    Then Check that the Login Page title is Welcome, Please Sign In