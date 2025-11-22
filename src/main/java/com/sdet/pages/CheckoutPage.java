package com.sdet.pages;

import com.microsoft.playwright.Page;

public class CheckoutPage extends BasePage {
    
    private static final String FIRST_NAME_INPUT = "[data-test='firstName']";
    private static final String LAST_NAME_INPUT = "[data-test='lastName']";
    private static final String POSTAL_CODE_INPUT = "[data-test='postalCode']";
    private static final String CONTINUE_BUTTON = ".btn_primary";
    private static final String FINISH_BUTTON = ".btn_action";
    private static final String COMPLETE_HEADER = ".complete-header";

    public CheckoutPage(Page page) {
        super(page);
    }

    public void enterCheckoutInformation(String firstName, String lastName, String postalCode) {
        page.fill(FIRST_NAME_INPUT, firstName);
        page.fill(LAST_NAME_INPUT, lastName);
        page.fill(POSTAL_CODE_INPUT, postalCode);
    }

    public void clickContinue() {
        page.click(CONTINUE_BUTTON);
    }

    public void clickFinish() {
        page.click(FINISH_BUTTON);
    }

    public void completeCheckout(String firstName, String lastName, String postalCode) {
        enterCheckoutInformation(firstName, lastName, postalCode);
        clickContinue();
        clickFinish();
    }

    public boolean isOrderComplete() {
        return isElementVisible(COMPLETE_HEADER);
    }

    public String getCompletionMessage() {
        return getElementText(COMPLETE_HEADER);
    }
}
