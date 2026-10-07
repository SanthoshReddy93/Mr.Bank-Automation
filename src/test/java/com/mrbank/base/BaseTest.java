package com.mrbank.base;

import com.microsoft.playwright.Page;
import com.mrbank.factory.PlaywrightFactory;
import com.mrbank.pages.DashboardPage;
import com.mrbank.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected PlaywrightFactory pf;
    protected Page page;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;

    @BeforeMethod
    public void setup() {
        pf = new PlaywrightFactory();
        page = pf.initBrowser();
        loginPage = new LoginPage(page);
        dashboardPage = new DashboardPage(page);
    }

    @AfterMethod
    public void teardown() {
        PlaywrightFactory.closeBrowser();
    }
}