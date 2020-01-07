package com.platform.project.Cucumber;

import com.platform.project.commons.PageObjectManager;
import com.platform.project.commons.WebDriverManager;

public class TestContext
{
    private WebDriverManager webDriverManager;
    private PageObjectManager pageObjectManager;

    public TestContext()
    {
        webDriverManager = new WebDriverManager();
        pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
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
