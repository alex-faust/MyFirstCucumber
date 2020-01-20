package com.platform.project.steps;

import com.platform.project.commons.Commons;
import com.platform.project.commons.TestContext;
import com.platform.project.pageObjects.CheckOutPage;
import com.platform.project.pageObjects.HomePage;
import com.platform.project.pageObjects.LogInPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

public class CheckOutPageSteps
{
    WebDriver driver;
    HomePage homePage;
    CheckOutPage checkOutPage;
    TestContext testContext;

    public CheckOutPageSteps(TestContext context)
    {
        testContext = context;
        driver = testContext.getWebDriverManager().getDriver();
        homePage = testContext.getPageObjectManager().getHomePage();
        checkOutPage = testContext.getPageObjectManager().getCheckOutPage();
    }

    @And("^I select items1 and verify that the cart content text is (.*)$")
    public void selectItems1(String expectedTitle)
    {
        Commons.check(driver, homePage.selectItems1().equals(expectedTitle), "Cart contents mismatch");
    }

    @Then("^I go to the cart contents$")
    public void goToCartContents()
    {
        homePage.goToCartContents();
    }

    @Then("^Verify that items and prices in cart are correct and checkout order page title is (.*)$")
    public void verifyAndCheckOut(String expectedTitle)
    {
        Commons.check(driver, checkOutPage.verifyCart().equals(expectedTitle), "buyProducts1Fail");
    }

    @And("^I select items2 and verify that the cart content text is (.*)$")
    public void selectItems2(String expectedTitle)
    {
        Commons.check(driver, homePage.selectItems2().equals(expectedTitle), "Cart contents mismatch");
    }

}
