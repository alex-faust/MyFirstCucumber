package com.platform.project.steps;

import com.platform.project.commons.Commons;
import com.platform.project.commons.ReadPropertyFile;
import com.platform.project.commons.WebDriverManager;
import com.platform.project.pageObjects.HomePage;
import com.platform.project.pageObjects.LogInPage;
import com.platform.project.pageObjects.WelcomePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class WelcomePageSteps
{
    WebDriver driver;
    LogInPage logInPage;
    HomePage homePage;
    WelcomePage welcomePage;
    WebDriverManager webDriverManager;

    @Before
    public void setUp()
    {
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver
                (Commons.createEnvVariable("browser", ReadPropertyFile.getConfigPropertyVal("browser")));
        homePage = new HomePage(driver);
        logInPage = new LogInPage(driver);
        welcomePage = new WelcomePage(driver);
    }

    @Then("^I enter incorrect user credentials$")
    public void noEmailPasswordMatch()
    {
        logInPage.enterUserDetailsError();
    }

    @Then("^Verify that the error message matches$")
    public void noPasswordMatch()
    {
        Commons.check(driver, logInPage.getErrorMsg().equals
                (" Error: No match for E-Mail Address and/or Password."),
                "noEmailPasswordMatchFail");
    }


    @After
    public void cleanUp()
    {
        driver.quit();
    }
}
