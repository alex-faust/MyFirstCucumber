@tagLogOff
Feature: LogOffPage feature

  #Background: Open Home Page and click log in link
    #Given I open the Home Page
    #Then I click on the login link

  @tagLogOff1
  Scenario: Enter the user details, log in, then log off correctly
    Given I open the Home Page
    Then I click on the login link
    Then I enter the users details
    Then I log off from the welcome page
    Then I verify that the log off page title is Log Off

  @tagLogOff2
  Scenario: Enter the user details from the configuration file
    Given I open the Home Page
    Then I click on the login link
    Then I enter the users details from configuration file
    Then I log off from the welcome page
    Then I verify that the log off page title is Log Off

  @tagLogOff3
  Scenario: Enter the user details from an excel file
    Given I open the Home Page
    Then I click on the login link
    Then I enter the users details from excel file
    Then I log off from the welcome page
    Then I verify that the log off page title is Log Off

  @tagLogOff4
  Scenario: Have two users log on at the same time
    Given I have both users open the home page
    Then I have both users click on the login link
    Then I have both users enter credentials to login
    Then I have both users click the log off button
    Then I verify both users have logged off and that the LogOff page title is Log Off