package com.mrbank.factory;

import com.microsoft.playwright.*;
import com.mrbank.utils.ConfigReader;

import java.awt.Dimension;
import java.awt.Toolkit;

public class PlaywrightFactory {

    private static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();
    private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
    private static ThreadLocal<Page> tlPage = new ThreadLocal<>();

    public static Playwright getPlaywright() {
        return tlPlaywright.get();
    }

    public static Browser getBrowser() {
        return tlBrowser.get();
    }

    public static BrowserContext getBrowserContext() {
        return tlBrowserContext.get();
    }

    public static Page getPage() {
        return tlPage.get();
    }

    public Page initBrowser() {
        String browserName = ConfigReader.getProperty("browser");
        boolean headless = Boolean.parseBoolean(ConfigReader.getProperty("headless"));

        tlPlaywright.set(Playwright.create());

        BrowserType browserType;
        if (browserName != null && browserName.equalsIgnoreCase("firefox")) {
            browserType = getPlaywright().firefox();
        } else if (browserName != null && browserName.equalsIgnoreCase("webkit")) {
            browserType = getPlaywright().webkit();
        } else {
            browserType = getPlaywright().chromium();
        }

        tlBrowser.set(browserType.launch(new BrowserType.LaunchOptions().setHeadless(headless)));

        int width = 1280;
        int height = 800;
        try {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            width = (int) screenSize.getWidth();
            height = (int) screenSize.getHeight();
        } catch (Exception e) {
            // Default dimension fallback if headless graphics env
        }

        tlBrowserContext.set(getBrowser().newContext(new Browser.NewContextOptions().setViewportSize(width, height)));
        tlPage.set(getBrowserContext().newPage());

        getPage().navigate(ConfigReader.getProperty("baseUrl"));
        return getPage();
    }

    public static void closeBrowser() {
        if (getPage() != null) {
            getPage().close();
        }
        if (getBrowserContext() != null) {
            getBrowserContext().close();
        }
        if (getBrowser() != null) {
            getBrowser().close();
        }
        if (getPlaywright() != null) {
            getPlaywright().close();
        }
    }
}