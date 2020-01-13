package com.platform.project.steps;

import com.platform.project.commons.Commons;
import com.platform.project.commons.TestContext;
import com.platform.project.pageObjects.ForgottenPasswordPage;
import com.platform.project.pageObjects.HomePage;
import com.platform.project.pageObjects.LogInPage;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

public class ForgottenPasswordPageSteps
{
    WebDriver driver;
    LogInPage logInPage;
    HomePage homePage;
    ForgottenPasswordPage forgottenPasswordPage;
    TestContext testContext;

    public ForgottenPasswordPageSteps(TestContext context)
    {
        testContext = context;
        driver = testContext.getWebDriverManager().getDriver();
        homePage = testContext.getPageObjectManager().getHomePage();
        logInPage = testContext.getPageObjectManager().getLogInPage();
        forgottenPasswordPage = testContext.getPageObjectManager().getForgottenPasswordPage();
    }

    @Then("^I click the password forgotten link$")
    public void clickForgottenPassworkBtn()
    {
        logInPage.passwordForgotten();
    }

    @Then("^Click continue and verify that the No Records Found message is(.*)$")
    public void verifyNoRecordsMessage(String expectedResult)
    {
        Commons.check(driver, forgottenPasswordPage.getNoRecordsFound().equals(expectedResult),
                "password forgotten error message has failed");
    }
    }

