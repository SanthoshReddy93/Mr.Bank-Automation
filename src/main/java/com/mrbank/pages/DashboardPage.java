package com.mrbank.pages;

import com.microsoft.playwright.Page;

public class DashboardPage {
    private final Page page;

    private final String logo = "img[alt='MrBanks']";
    private final String competitionsNavLink = "a[href='/competitions']";

    public DashboardPage(Page page) {
        this.page = page;
    }

    public boolean isLogoDisplayed() {
        return page.isVisible(logo);
    }

    public boolean isCompetitionsNavVisible() {
        return page.isVisible(competitionsNavLink);
    }

    public CompetitionsPage clickCompetitionsNav() {
        page.click(competitionsNavLink);
        return new CompetitionsPage(page);
    }

    public String getPageTitle() {
        return page.title();
    }
}