package com.mrbank.pages;

import com.microsoft.playwright.Page;

public class CheckoutPage {
    private final Page page;

    private final String ticketQuantityInput = "input[type='number']";
    private final String proceedToPaymentBtn = "button:has-text('Proceed')";

    public CheckoutPage(Page page) {
        this.page = page;
    }

    public boolean isCheckoutElementVisible() {
        return page.isVisible(proceedToPaymentBtn) || page.isVisible(ticketQuantityInput);
    }
}