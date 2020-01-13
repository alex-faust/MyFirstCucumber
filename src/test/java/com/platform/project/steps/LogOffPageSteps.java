package com.platform.project.steps;

import com.platform.project.commons.Commons;
import com.platform.project.commons.TestContext;
import com.platform.project.pageObjects.HomePage;
import com.platform.project.pageObjects.LogInPage;
import com.platform.project.pageObjects.LogOffPage;
import com.platform.project.pageObjects.WelcomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

public class LogOffPageSteps
{
    WebDriver driver, driver1;
    LogInPage logInPage, logInPage1;
    HomePage homePage, homePage1;
    WelcomePage welcomePage, welcomePage1;
    LogOffPage logOff, logOff1;
    TestContext testContext, testContext1;

    public LogOffPageSteps(TestContext context, TestContext context1)
    {
        testContext = context;
        //testContext1 = new TestContext();
        testContext1 = context1;

        driver = testContext.getWebDriverManager().getDriver();
        driver1 = testContext1.getWebDriverManager().getDriver("firefox");

        homePage = testContext.getPageObjectManager().getHomePage();
        homePage1 = testContext1.getPageObjectManager().getHomePage();

        logInPage = testContext.getPageObjectManager().getLogInPage();
        logInPage1 = testContext1.getPageObjectManager().getLogInPage();

        logOff = testContext.getPageObjectManager().getLogOffPage();
        logOff1 = testContext1.getPageObjectManager().getLogOffPage();

        welcomePage = testContext.getPageObjectManager().getWelcomePage();
        welcomePage1 = testContext1.getPageObjectManager().getWelcomePage();

    }

    @Then("^I enter the users details$")
    public void enterUserDetails()
    {
        logInPage.enterUserDetails();
    }

    @Then("^I log off from the welcome page$")
    public void logOffFromWelcomePage()
    {
        welcomePage.logOff();
    }

    @Then("^I verify that the log off page title is (.*)$")
    public void verifyLogOffPage(String expectedTitle)
    {
        Commons.check(driver, logOff.getPageTitle().equals
                (expectedTitle), "Failed to reach LogOffPage");

    }

    @Then("^I enter the users details from configuration file$")
    public void enterCredFromConfig()
    {
        logInPage.enterUserDetailsFromConfig();
    }

    @Then("^I enter the users details from excel file$")
    public void enterCredFromExcel()
    {
        logInPage.enterUserDetailsFromExcel();
    }

    @Given("^I have both users open the home page$")
    public void twoUsersOpenHomePage()
    {
        homePage.openHomePage();
        homePage1.openHomePage();
    }

    @Then("^I have both users click on the login link$")
    public void twoUsersClickLoginBtn()
    {
        homePage.clickLogInText();
        homePage1.clickLogInText();
    }

    @Then("^I have both users enter credentials to login$")
    public void twoUsersEnterDetails()
    {
        logInPage.enterUserDetailsFromConfig();
        logInPage1.enterUserDetails();
    }

    @Then("^I have both users click the log off button$")
    public void twoUsersClickLogOffBtn()
    {
        welcomePage.logOff();
        welcomePage1.logOff();
    }

    @Then("^I verify both users have logged off and that the LogOff page title is (.*)$")
    public void verifyBOthUsersLogOff(String expectedTitle)
    {
        Commons.check(driver, logOff.getPageTitle().equals(expectedTitle), "firstOfTwoUsersFail");
        Commons.check(driver1, logOff1.getPageTitle().equals(expectedTitle), "secondOfTwoUsersFail");
    }
}

