Feature: LoginPage feature

  @Test
  Scenario: Verify LoginPage loaded
    Given I open the Home Page
    Then I click on the login link
    Then Check the Login Page title is correct