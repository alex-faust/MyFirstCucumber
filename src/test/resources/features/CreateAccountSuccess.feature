@tagCAS
Feature: Create Account Success feature

  Scenario: Creating an account
    Given I open the Home Page
    Then I click on the create account button
    Then I enter information to create an account
    Then Verify that the create account text is Your Account Has Been Created!