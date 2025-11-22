package com.sdet.pages;

import com.microsoft.playwright.Page;

public class CartPage extends BasePage {
    
    private static final String CART_TITLE = ".title";
    private static final String CART_ITEMS = ".cart_item";
    private static final String CHECKOUT_BUTTON = ".checkout_button";
    private static final String REMOVE_BUTTON = ".cart_button";

    public CartPage(Page page) {
        super(page);
    }

    public boolean isCartPageDisplayed() {
        return isElementVisible(CART_TITLE) && 
               getElementText(CART_TITLE).equals("Your Cart");
    }

    public int getCartItemsCount() {
        return page.locator(CART_ITEMS).count();
    }

    public CheckoutPage clickCheckout() {
        page.click(CHECKOUT_BUTTON);
        return new CheckoutPage(page);
    }

    public void removeItemByIndex(int index) {
        page.locator(REMOVE_BUTTON).nth(index).click();
    }
}
