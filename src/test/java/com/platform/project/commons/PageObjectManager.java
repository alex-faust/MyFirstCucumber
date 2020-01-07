package com.platform.project.commons;

import com.platform.project.pageObjects.HomePage;
import com.platform.project.pageObjects.LogInPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager
{
    private WebDriver driver;
    private HomePage homePage;
    private LogInPage logInPage;

    public PageObjectManager(WebDriver driver)
    {
        this.driver = driver;
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
