package com.mrbank.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;

    private final String emailInput = "input[type='email']";
    private final String passwordInput = "input[type='password']";
    private final String submitButton = "button[type='submit']";
    private final String signInNavLink = "a[href='/login']";
    private final String errorMessageAlert = ".text-red-500, [role='alert'], .error-message";

    public LoginPage(Page page) {
        this.page = page;
    }

    public void navigateToLoginPage() {
        if (page.isVisible(signInNavLink)) {
            page.click(signInNavLink);
        } else if (!page.url().contains("/login")) {
            String url = page.url();
            String loginUrl = url.endsWith("/") ? url + "login" : url + "/login";
            page.navigate(loginUrl);
        }
    }

    public void enterEmail(String email) {
        page.fill(emailInput, email);
    }

    public void enterPassword(String password) {
        page.fill(passwordInput, password);
    }

    public void clickSubmit() {
        if (page.isVisible(submitButton)) {
            page.click(submitButton);
        }
    }

    public DashboardPage performLogin(String email, String password) {
        navigateToLoginPage();
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
        return new DashboardPage(page);
    }

    public boolean isLoginButtonVisible() {
        return page.isVisible(submitButton) || page.isVisible(signInNavLink);
    }

    public String getErrorMessage() {
        if (page.isVisible(errorMessageAlert)) {
            return page.innerText(errorMessageAlert);
        }
        return "";
    }
}