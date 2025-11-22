package com.sdet.pages;

import com.microsoft.playwright.Page;

public class ProductsPage extends BasePage {
    
    private static final String PRODUCTS_TITLE = ".title";
    private static final String INVENTORY_ITEMS = ".inventory_item";
    private static final String ADD_TO_CART_BUTTON = ".btn_inventory";
    private static final String SHOPPING_CART_BADGE = ".shopping_cart_badge";
    private static final String SHOPPING_CART_LINK = ".shopping_cart_link";
    private static final String HAMBURGER_MENU = ".bm-burger-button";
    private static final String LOGOUT_LINK = "#logout_sidebar_link";

    public ProductsPage(Page page) {
        super(page);
    }

    public boolean isProductsPageDisplayed() {
        return isElementVisible(PRODUCTS_TITLE) && 
               getElementText(PRODUCTS_TITLE).equals("Products");
    }

    public String getProductsTitle() {
        return getElementText(PRODUCTS_TITLE);
    }

    public int getInventoryItemsCount() {
        return page.locator(INVENTORY_ITEMS).count();
    }

    public void addProductToCartByIndex(int index) {
        page.locator(ADD_TO_CART_BUTTON).nth(index).click();
    }

    public void addFirstProductToCart() {
        addProductToCartByIndex(0);
    }

    public String getCartBadgeCount() {
        if (isElementVisible(SHOPPING_CART_BADGE)) {
            return getElementText(SHOPPING_CART_BADGE);
        }
        return "0";
    }

    public CartPage clickShoppingCart() {
        page.click(SHOPPING_CART_LINK);
        return new CartPage(page);
    }

    public void openHamburgerMenu() {
        page.click(HAMBURGER_MENU);
        page.waitForTimeout(500);
    }

    public LoginPage logout() {
        openHamburgerMenu();
        page.click(LOGOUT_LINK);
        return new LoginPage(page);
    }
}
