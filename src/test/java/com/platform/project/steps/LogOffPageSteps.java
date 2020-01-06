package com.platform.project.steps;

import com.platform.project.commons.Commons;
import com.platform.project.commons.ReadPropertyFile;
import com.platform.project.commons.WebDriverManager;
import com.platform.project.pageObjects.HomePage;
import com.platform.project.pageObjects.LogInPage;
import com.platform.project.pageObjects.LogOffPage;
import com.platform.project.pageObjects.WelcomePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

public class LogOffPageSteps
{
    WebDriver driver, driver1;
    LogInPage logInPage, logInPage1;
    HomePage homePage, homePage1;
    WelcomePage welcomePage, welcomePage1;
    WebDriverManager webDriverManager, webDriverManager1;
    LogOffPage logOff, logOff1;

    @Before
    public void setUp()
    {
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver
                (Commons.createEnvVariable("browser", ReadPropertyFile.getConfigPropertyVal("browser")));
        homePage = new HomePage(driver);
        logInPage = new LogInPage(driver);
        welcomePage = new WelcomePage(driver);
        logOff = new LogOffPage(driver);

        webDriverManager1 = new WebDriverManager();
        driver1 = webDriverManager.getDriver
                (Commons.createEnvVariable("browser", ReadPropertyFile.getConfigPropertyVal("browser")));
        homePage1 = new HomePage(driver1);
        logInPage1 = new LogInPage(driver1);
        welcomePage1 = new WelcomePage(driver1);
        logOff1 = new LogOffPage(driver1);
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

    @Then("^I verify that I have arrived at the log off page$")
    public void verifyLogOffPage()
    {
        Commons.check(driver, logOff.getPageTitle().equals
                ("Log Off"), "Failed to reach LogOffPage");

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

    @Then("^I verify both users have logged off$")
    public void verifyBOthUsersLogOff()
    {
        Commons.check(driver, logOff.getPageTitle().equals("Log Off"), "firstOfTwoUsersFail");
        Commons.check(driver, logOff.getPageTitle().equals("Log Off"), "secondOfTwoUsersFail");
    }

    @After
    public void cleanUp()
    {
        driver.quit();
        driver1.quit();
    }
}

