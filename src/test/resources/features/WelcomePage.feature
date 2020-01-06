Feature: WelcomePage feature

  Scenario: Having no Email/Password match
    Given I open the Home Page
    Then I click on the login link
    Then I enter incorrect user credentials
    Then Verify that the error message matches