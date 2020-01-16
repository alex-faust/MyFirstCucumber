@tagForgot
Feature: ForgottenPasswordPage feature

  Scenario: User has forgotten password
    Given I open the Home Page
    Then I click on the login link
    Then I click the password forgotten link
    Then Click continue and verify that the No Records Found message is Error: The E-Mail Address was not found in our records, please try again.