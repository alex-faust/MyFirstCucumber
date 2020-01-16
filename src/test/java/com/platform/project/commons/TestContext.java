package com.platform.project.commons;

public class TestContext
{
    private WebDriverManager webDriverManager;
    private PageObjectManager pageObjectManager;

    /*public TestContext()
    {
        webDriverManager = new WebDriverManager();
        pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
    }*/

    public TestContext(String browser)
    {
        if(browser == null)
        {
            webDriverManager = new WebDriverManager();
            pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
        } else
        {
            webDriverManager = new WebDriverManager();
            pageObjectManager = new PageObjectManager(webDriverManager.getDriver(browser));
        }
    }

    public WebDriverManager getWebDriverManager()
    {
        return webDriverManager;
    }

    public PageObjectManager getPageObjectManager()
    {
        return pageObjectManager;
    }
}
