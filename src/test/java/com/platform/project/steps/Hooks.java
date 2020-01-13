package com.platform.project.steps;

import com.platform.project.commons.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks
{
    TestContext testContext, testContext1;

    public Hooks(TestContext context)
    {
        testContext = context;
    }
    /*public Hooks(TestContext context, TestContext context1)
    {
        testContext = context;
        testContext1 = context1;
    }*/

    @Before
    public void BeforeSteps() {}

    @After
    public void AfterSteps()
    {
        testContext.getWebDriverManager().quitDriver();
        /*if (testContext1 != null)
        {
            testContext1.getWebDriverManager().quitDriver();
        }*/
    }
}
