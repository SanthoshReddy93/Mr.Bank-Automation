package com.mrbank.pages;

import com.microsoft.playwright.Page;

public class CompetitionsPage {
    private final Page page;

    private final String competitionsTitle = "h4:has-text('ALL COMPETITIONS')";
    private final String trendingCompetitionLink = "a[href*='/competitions']";

    public CompetitionsPage(Page page) {
        this.page = page;
    }

    public boolean isCompetitionsHeaderVisible() {
        return page.isVisible(competitionsTitle) || page.isVisible(trendingCompetitionLink);
    }

    public int getCompetitionsCount() {
        return page.locator(trendingCompetitionLink).count();
    }
}