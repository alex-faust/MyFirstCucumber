@tagCheckOut
Feature: CheckOut Page feature

  @tagCheckOut1
  Scenario: Buying products using Home Page
    Given I open the Home Page
    Then I click on the login link
    Then I enter the users details from configuration file
    And I select items1 and verify that the cart content text is Cart Contents (5)
    Then I go to the cart contents
    Then Verify that items and prices in cart are correct and checkout order page title is Your Order Has Been Processed!

  @tagCheckOut2
  Scenario: Buying products by navigating back twice
    Given I open the Home Page
    Then I click on the login link
    Then I enter the users details from configuration file
    And I select items2 and verify that the cart content text is Cart Contents (5)
    Then I go to the cart contents
    Then Verify that items and prices in cart are correct and checkout order page title is Your Order Has Been Processed!