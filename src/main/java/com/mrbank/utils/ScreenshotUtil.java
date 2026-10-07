package com.mrbank.utils;

import com.microsoft.playwright.Page;
import com.mrbank.factory.PlaywrightFactory;
import io.qameta.allure.Attachment;

public class ScreenshotUtil {

    @Attachment(value = "Failure Screenshot", type = "image/png")
    public static byte[] takeScreenshot() {
        Page page = PlaywrightFactory.getPage();
        if (page != null) {
            return page.screenshot(new Page.ScreenshotOptions().setFullPage(true));
        }
        return new byte[0];
    }
}