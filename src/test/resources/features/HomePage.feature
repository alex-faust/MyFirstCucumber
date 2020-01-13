@tagHome
Feature: HomePage feature

  @tag1
  Scenario: Verify Home Page Loaded
    Given I open the Home Page
    Then Check that the Home Page title is Welcome to iBusiness

  @tag3
  Scenario: Verify Dropdown menu
    Given I open the Home Page
    Then I go to the drop down menu and compare the contents

    @tag4 @reg
  Scenario: Open all links on Home Page
    Given I open the Home Page
    Then I collect and open each link on the page

  #Scenario: Verify Home Page Loaded 3
  # Given I open the Home Page
  # Then Check that the Home Page title is Welcome to iBusiness

 # @tag5 @reg @smoke
  #Scenario Outline: Verify Home Page Loaded 4
  #  Given I open the Home Page
   # Then Check that the Home Page title is <pageTitle>

  #  Examples:
  #    | pageTitle             |
   #   | Welcome to iBusiness4  |
  #    | Welcome to iBusiness5 |

  #Scenario Outline: Verify Home Page Loaded 5
   # Given I open the Home Page
   # Then Check that the Home Page title is <pageTitle>
   # When I Click on button
   # Then Check that the login page title is <logintitle>
   # When I enter username <username> and password <password>

  #  Examples:
  #    | pageTitle             | logintitle    | username | password
  #    | Welcome to iBusiness  | login1        | us1      |  ps1
  #    | Welcome to iBusiness2 | login2        | us2      |  ps2
