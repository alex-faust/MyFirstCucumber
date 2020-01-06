package com.platform.project.steps;

import com.platform.project.commons.Commons;
import com.platform.project.commons.ReadPropertyFile;
import com.platform.project.commons.WebDriverManager;
import com.platform.project.pageObjects.HomePage;
import com.platform.project.pageObjects.LogInPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

public class LoginPageSteps
{
    WebDriver driver;
    LogInPage logInPage;
    HomePage homePage;
    WebDriverManager webDriverManager;

    @Before
    public void setUp()
    {
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver
                (Commons.createEnvVariable("browser", ReadPropertyFile.getConfigPropertyVal("browser")));
        homePage = new HomePage(driver);
        logInPage = new LogInPage(driver);
    }

    @After
    public void cleanUp()
    {
        driver.quit();
    }

    @Then("^I click on the login link$")
    public void clickLoginLink()
    {
        homePage.clickLogInText();
    }

    @Then("^Check the Login Page title is correct$")
    public void verifyLoginPageText()
    {
        Commons.check(driver, logInPage.getPageTitle().equals
                ("Welcome, Please Sign In"), "openLoginPageFail");
    }

}
