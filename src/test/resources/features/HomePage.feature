Feature: HomePage feature

  Scenario: Verify Home Page Loaded
    Given I open the Home Page
    Then Check the Home Page title is correct

  Scenario: Verify Home Page Loaded 2
    Given I open the Home Page
    Then Check the Home Page title is correct2

  Scenario: Verify Dropdown menu
    Given I open the Home Page
    Then I go to the drop down menu and compare the contents

  Scenario: Open all links on Home Page
    Given I open the Home Page
    Then I collect and open each link on the page