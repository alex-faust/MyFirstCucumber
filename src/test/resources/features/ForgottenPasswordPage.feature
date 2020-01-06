Feature: ForgottenPasswordPage feature

  Scenario: User has forgotten password
    Given I open the Home Page
    Then I click on the login link
    Then I click the password forgotten button
    Then Verify the No Records Found message