@tagCheckOut
Feature: CheckOut Page feature

  @tagCheckOut1 @tagError
  Scenario: Buying products using Home Page
    Given I open the Home Page
    Then I click on the login link
    Then I enter the users details from configuration file
    Then I select items by clicking them and continuing by returning to the Home Page
    Then I go to the cart contents
    Then Verify that items and prices in cart are correct and checkout order page title is Your Order Has Been Processed!

  @tagCheckOut2 @tagError
  Scenario: Buying products by navigating back twice
    Given I open the Home Page
    Then I click on the login link
    Then I enter the users details from configuration file
    Then I select items by clicking them returning to the Home Page by clicking back twice
    Then I go to the cart contents
    Then Verify that items and prices in cart are correct and checkout order page title is Your Order Has Been Processed!