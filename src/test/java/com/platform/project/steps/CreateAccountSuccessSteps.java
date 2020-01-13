package com.platform.project.steps;

import com.platform.project.commons.Commons;
import com.platform.project.commons.TestContext;
import com.platform.project.pageObjects.CreateAccountSuccess;
import com.platform.project.pageObjects.HomePage;
import com.platform.project.pageObjects.LogInPage;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

public class CreateAccountSuccessSteps
{
    WebDriver driver;
    HomePage homePage;
    CreateAccountSuccess cas;
    TestContext testContext;
    //LogInPage logInPage;

    public CreateAccountSuccessSteps(TestContext context)
    {
        testContext = context;
        driver = testContext.getWebDriverManager().getDriver();
        homePage = testContext.getPageObjectManager().getHomePage();
        //logInPage = testContext.getPageObjectManager().getLogInPage();
        cas = testContext.getPageObjectManager().getCreateAccountSuccess();
    }

    @Then("^I click on the create account button$")
    public void clickCreateAccountBtn()
    {
        homePage.clickCreateAccount();
    }

    @Then("^I enter information to create an account$")
    public void createAccount()
    {
        cas.createAnAccount();
    }

    @Then("^Verify that the create account text is (.*)$")
    public void verifyAccountCreated(String expectedTitle)
    {
        Commons.check(driver, cas.getPageTitle().equals
                (expectedTitle), "failed to create an account.");
    }
}