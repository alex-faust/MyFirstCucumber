package com.platform.project.steps;

import com.platform.project.commons.Commons;
import com.platform.project.commons.TestContext;
import com.platform.project.pageObjects.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;

public class HomePageSteps
{
    WebDriver driver;
    HomePage homePage;
    TestContext testContext;

    public HomePageSteps(TestContext context)
    {
        testContext = context;
        driver = testContext.getWebDriverManager().getDriver();
        homePage = testContext.getPageObjectManager().getHomePage();
    }

    @Given("^I open the Home Page$")
    public void openHomePage()
    {
        homePage.openHomePage();
    }

    @Then("^Check that the Home Page title is (.*)$")
    public void verifyHomePageTitle(String expectedTitle)
    {
        Commons.check(driver, homePage.getPageTitle().equals(expectedTitle), "Home Page Title didn't match.");
    }

    @Then("^I go to the drop down menu and compare the contents$")
    public void dropDownMenu()
    {
        String[] elementB = new String[]{"[Canon]", "[Fox]", "[GT, Interactive]", "[Hewlett, Packard]", "[Logitech]", "[Matrox]", "[Microsoft]", "[Samsung]", "[Sierra]", "[Warner]"};
        String[] elementA = homePage.dropDownMenu();
        Commons.check(driver, Arrays.toString(elementA).equals(Arrays.toString(elementB)), "dropDownMenuFail");
    }

    @Then("^I collect and open each link on the page$")
    public void openAllLinks()
    {
        Commons.check(driver, homePage.checkAllLinks() == 0,
                "There are some broken links.");
    }

}

