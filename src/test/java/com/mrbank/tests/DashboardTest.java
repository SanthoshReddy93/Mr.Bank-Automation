package com.mrbank.tests;

import com.mrbank.base.BaseTest;
import com.mrbank.pages.CompetitionsPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Dashboard")
@Feature("Main Dashboard Navigation")
public class DashboardTest extends BaseTest {

    @Test(priority = 1, description = "Verify Main Page Header and Logo")
    @Story("Dashboard Header")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that the application logo is visible on the home dashboard.")
    public void testDashboardLogo() {
        Assert.assertTrue(dashboardPage.isLogoDisplayed(), "MrBanks Logo should be visible on dashboard");
    }

    @Test(priority = 2, description = "Verify Navigation to Competitions Module")
    @Story("Competitions Redirection")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify clicking Competitions in navbar opens Competitions page.")
    public void testNavigateToCompetitions() {
        CompetitionsPage competitionsPage = dashboardPage.clickCompetitionsNav();
        Assert.assertTrue(competitionsPage.isCompetitionsHeaderVisible(), "Competitions page should be displayed");
    }
}