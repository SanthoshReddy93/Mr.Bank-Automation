package com.mrbank.tests;

import com.mrbank.base.BaseTest;
import com.mrbank.utils.ConfigReader;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Authentication")
@Feature("Login Functionality")
public class LoginTest extends BaseTest {

    @Test(priority = 1, description = "Verify Login Page Navigation and Elements")
    @Story("Login Navigation")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that the user can navigate to the Login page and elements are displayed.")
    public void testLoginPageElements() {
        loginPage.navigateToLoginPage();
        Assert.assertTrue(loginPage.isLoginButtonVisible(), "Login button/input should be visible on Login Page");
    }

    @Test(priority = 2, description = "Verify Login with Valid Credentials")
    @Story("Valid Login")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test login functionality using valid email and password.")
    public void testValidLogin() {
        String email = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");
        
        loginPage.performLogin(email, password);
        Assert.assertTrue(dashboardPage.isLogoDisplayed(), "Dashboard logo should be displayed after login");
    }

    @Test(priority = 3, description = "Verify Login with Invalid Credentials")
    @Story("Invalid Login")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that invalid login displays an error message or retains login inputs.")
    public void testInvalidLogin() {
        loginPage.performLogin("invalid_user@gmail.com", "WrongPass123!");
        Assert.assertTrue(loginPage.isLoginButtonVisible(), "Should remain on Login Page after invalid login attempt");
    }
}