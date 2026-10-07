package com.mrbank.tests;

import com.mrbank.base.BaseTest;
import com.mrbank.pages.CompetitionsPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Competitions")
@Feature("Competitions Module")
public class CompetitionsTest extends BaseTest {

    @Test(priority = 1, description = "Verify Competitions Header and Listings")
    @Story("Competitions Listing")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that competitions module renders competition headers and elements.")
    public void testCompetitionsListing() {
        CompetitionsPage competitionsPage = dashboardPage.clickCompetitionsNav();
        Assert.assertTrue(competitionsPage.isCompetitionsHeaderVisible(), "Competitions header should be visible");
    }
}