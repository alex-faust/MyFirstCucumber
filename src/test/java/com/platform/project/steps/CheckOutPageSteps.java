package com.platform.project.steps;

import com.platform.project.commons.Commons;
import com.platform.project.commons.ReadPropertyFile;
import com.platform.project.commons.WebDriverManager;
import com.platform.project.pageObjects.CheckOutPage;
import com.platform.project.pageObjects.HomePage;
import com.platform.project.pageObjects.LogInPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

public class CheckOutPageSteps
{
    WebDriver driver;
    HomePage homePage;
    LogInPage logInPage;
    WebDriverManager webDriverManager;
    CheckOutPage checkOutPage;

    @Before
    public void setUp()
    {
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver
                (Commons.createEnvVariable("browser", ReadPropertyFile.getConfigPropertyVal("browser")));
        homePage = new HomePage(driver);
        logInPage = new LogInPage(driver);
        checkOutPage = new CheckOutPage(driver);
    }

    @Then("^I select items by clicking them and continuing by returning to the Home Page$")
    public void selectItems1()
    {
        homePage.selectItems1();
    }

    @Then("^I go to the cart contents$")
    public void goToCartContents()
    {
        homePage.goToCartContents();
    }

    @Then("^Verify that items and prices in cart are correct and checkout order$")
    public void verifyAndCheckOut()
    {
        Commons.check(driver, checkOutPage.verifyCart().equals
                ("Your Order Has Been Processed!"), "buyProducts1Fail");
    }

    @Then("^I select items by clicking them returning to the Home Page by clicking back twice$")
    public void selectItems2()
    {
        homePage.selectItems2();
    }

    @After
    public void cleanUp()
    {
        driver.quit();
    }
}
