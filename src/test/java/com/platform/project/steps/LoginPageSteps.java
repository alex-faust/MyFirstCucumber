package com.platform.project.steps;

import com.platform.project.commons.Commons;
import com.platform.project.commons.TestContext;
import com.platform.project.pageObjects.HomePage;
import com.platform.project.pageObjects.LogInPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

public class LoginPageSteps
{
    WebDriver driver;
    LogInPage logInPage;
    HomePage homePage;
    TestContext testContext;

    public LoginPageSteps(TestContext context)
    {
        testContext = context;
        driver = testContext.getWebDriverManager().getDriver();
        homePage = testContext.getPageObjectManager().getHomePage();
        logInPage = testContext.getPageObjectManager().getLogInPage();
    }

    @Given("^I click on the login link$")
    public void clickLoginLink()
    {
        homePage.clickLogInText();
    }

    @Then("^Check that the Login Page title is (.*)$")
    public void verifyLoginPageText(String expectedTitle)
    {
        Commons.check(driver, logInPage.getPageTitle().equals
                (expectedTitle), "Login page title is incorrect");
    }

}
