package com.platform.project.steps;

import com.platform.project.commons.Commons;
import com.platform.project.commons.TestContext;
import com.platform.project.pageObjects.CheckOutPage;
import com.platform.project.pageObjects.HomePage;
import com.platform.project.pageObjects.LogInPage;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

public class CheckOutPageSteps
{
    WebDriver driver;
    HomePage homePage;
    //LogInPage logInPage;
    CheckOutPage checkOutPage;
    TestContext testContext;

    public CheckOutPageSteps(TestContext context)
    {
        testContext = context;
        driver = testContext.getWebDriverManager().getDriver();
        homePage = testContext.getPageObjectManager().getHomePage();
        //logInPage = testContext.getPageObjectManager().getLogInPage();
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

    @Then("^Verify that items and prices in cart are correct and checkout order page title is(.*)$")
    public void verifyAndCheckOut(String expectedTitle)
    {
        Commons.check(driver, checkOutPage.verifyCart().equals
                (expectedTitle), "buyProducts1Fail");
    }

    @Then("^I select items by clicking them returning to the Home Page by clicking back twice$")
    public void selectItems2()
    {
        homePage.selectItems2();
    }

}
