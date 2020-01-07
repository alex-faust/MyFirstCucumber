Feature: LoginPage feature

  Background: User has arrived at the Home Page
    Given I open the Home Page

  @Test
  Scenario: Verify LoginPage loaded
    Given  I click on the login link
    Then Check the Login Page title is correct