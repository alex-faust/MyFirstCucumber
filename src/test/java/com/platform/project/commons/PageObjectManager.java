package com.platform.project.commons;

import com.platform.project.pageObjects.*;
import org.openqa.selenium.WebDriver;

public class PageObjectManager
{
    private WebDriver driver;
    private HomePage homePage;
    private LogInPage logInPage;
    private CheckOutPage checkOutPage;
    private ForgottenPasswordPage forgottenPasswordPage;
    private WelcomePage welcomePage;
    private LogOffPage logOffPage;
    private CreateAccountSuccess createAccountSuccess;

    public PageObjectManager(WebDriver driver)
    {
        this.driver = driver;
    }

    public CheckOutPage getCheckOutPage()
    {
        return (checkOutPage == null) ? checkOutPage = new CheckOutPage(driver) : checkOutPage;
    }

    public ForgottenPasswordPage getForgottenPasswordPage()
    {
        return (forgottenPasswordPage == null) ? forgottenPasswordPage = new ForgottenPasswordPage(driver) : forgottenPasswordPage;
    }

    public WelcomePage getWelcomePage()
    {
        return (welcomePage == null) ? welcomePage = new WelcomePage(driver) : welcomePage;
    }

    public LogOffPage getLogOffPage()
    {
        return (logOffPage == null) ? logOffPage = new LogOffPage(driver) : logOffPage;
    }

    public CreateAccountSuccess getCreateAccountSuccess()
    {
        return (createAccountSuccess == null) ? createAccountSuccess = new CreateAccountSuccess(driver) : createAccountSuccess;
    }

    public HomePage getHomePage()
    {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    public LogInPage getLogInPage()
    {
        return (logInPage == null) ? logInPage = new LogInPage(driver) : logInPage;
    }
}
