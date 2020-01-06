package com.platform.project.steps;

import com.platform.project.commons.Commons;
import com.platform.project.commons.ReadPropertyFile;
import com.platform.project.commons.WebDriverManager;
import com.platform.project.pageObjects.ForgottenPasswordPage;
import com.platform.project.pageObjects.HomePage;
import com.platform.project.pageObjects.LogInPage;
import com.platform.project.pageObjects.WelcomePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgottenPasswordPageSteps
{
    WebDriver driver;
    LogInPage logInPage;
    HomePage homePage;
    WelcomePage welcomePage;
    WebDriverManager webDriverManager;
    ForgottenPasswordPage forgottenPasswordPage;

    @Before
    public void setUp()
    {
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver
                (Commons.createEnvVariable("browser", ReadPropertyFile.getConfigPropertyVal("browser")));
        homePage = new HomePage(driver);
        logInPage = new LogInPage(driver);
        welcomePage = new WelcomePage(driver);
        forgottenPasswordPage = new ForgottenPasswordPage(driver);

    }

    @Then("^I click the password forgotten button$")
    public void clickForgottenPassworkBtn()
    {
        logInPage.passwordForgotten();
    }

    @Then("^Verify the No Records Found message$")
    public void verifyNoRecordsMessage()
    {
        Commons.check(driver, forgottenPasswordPage.getNoRecordsFound().equals(" Error: The E-Mail Address was not " +
                "found in our records, please try again."), "forgotPasswordFail");
    }

    @After
    public void cleanUp()
    {
        driver.quit();
    }

}

