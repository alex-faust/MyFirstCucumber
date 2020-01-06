Feature: Create Account Success feature

  @Test
  Scenario: Creating an account
    Given I open the Home Page
    Then I click on the create account button
    Then I enter information to create an account
    Then Verify that I have created an account