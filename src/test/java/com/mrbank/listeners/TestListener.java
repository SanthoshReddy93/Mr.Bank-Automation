package com.mrbank.listeners;

import com.mrbank.utils.ScreenshotUtil;
import io.qameta.allure.Allure;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class TestListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("PASSED TEST: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("FAILED TEST: " + result.getName() + " - Exception: " + result.getThrowable());
        byte[] screenshot = ScreenshotUtil.takeScreenshot();
        if (screenshot.length > 0) {
            Allure.addAttachment("Failure Screenshot - " + result.getName(), new ByteArrayInputStream(screenshot));
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("SKIPPED TEST: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("TEST SUITE STARTED: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("TEST SUITE FINISHED: " + context.getName());
    }
}