package com.platform.project.steps;

import com.platform.project.commons.Commons;
import com.platform.project.commons.TestContext;
import com.platform.project.pageObjects.HomePage;
import com.platform.project.pageObjects.LogInPage;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

public class WelcomePageSteps
{
    WebDriver driver;
    LogInPage logInPage;
    HomePage homePage;
    TestContext testContext;

    public WelcomePageSteps(TestContext context)
    {
        testContext = context;
        driver = testContext.getWebDriverManager().getDriver();
        homePage = testContext.getPageObjectManager().getHomePage();
        logInPage = testContext.getPageObjectManager().getLogInPage();
    }

    @Then("^I enter incorrect user credentials$")
    public void noEmailPasswordMatch()
    {
        logInPage.enterUserDetailsError();
    }

    @Then("^Verify that the error message matches(.*)$")
    public void noPasswordMatch(String expectedTitle)
    {
        Commons.check(driver, logInPage.getErrorMsg().equals
                (expectedTitle),
                "noEmailPasswordMatchFail");
    }
}
