package com.platform.project.steps;

import com.platform.project.commons.Commons;
import com.platform.project.commons.ReadPropertyFile;
import com.platform.project.commons.WebDriverManager;
import com.platform.project.pageObjects.CreateAccountSuccess;
import com.platform.project.pageObjects.HomePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

public class CreateAccountSuccessSteps
{
    WebDriver driver;
    HomePage homePage;
    WebDriverManager webDriverManager;
    CreateAccountSuccess cas;

    @Before
    public void setUp()
    {
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver
                (Commons.createEnvVariable("browser", ReadPropertyFile.getConfigPropertyVal("browser")));
        homePage = new HomePage(driver);
        cas = new CreateAccountSuccess(driver);
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

    @Then("^Verify that I have created an account$")
    public void verifyAccountCreated()
    {
        Commons.check(driver, cas.getPageTitle().equals
                ("Your Account Has Been Created!"), "createAnAccountFail");
    }

    @After
    public void cleanUp()
    {
        driver.quit();
    }
}