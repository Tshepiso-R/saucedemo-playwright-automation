package com.sdet.pages;

import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {
    
    private static final String USERNAME_INPUT = "#user-name";
    private static final String PASSWORD_INPUT = "#password";
    private static final String LOGIN_BUTTON = "#login-button";
    private static final String ERROR_MESSAGE = "[data-test='error']";
    private static final String LOGIN_LOGO = ".login_logo";

    public LoginPage(Page page) {
        super(page);
    }

    public void navigateToLoginPage() {
        navigateTo("https://www.saucedemo.com/v1/");
    }

    public void enterUsername(String username) {
        page.fill(USERNAME_INPUT, username);
    }

    public void enterPassword(String password) {
        page.fill(PASSWORD_INPUT, password);
    }

    public void clickLoginButton() {
        page.click(LOGIN_BUTTON);
    }

    public ProductsPage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        return new ProductsPage(page);
    }

    public boolean isLoginPageDisplayed() {
        return isElementVisible(LOGIN_LOGO);
    }

    public String getErrorMessage() {
        return getElementText(ERROR_MESSAGE);
    }

    public boolean isErrorMessageDisplayed() {
        return isElementVisible(ERROR_MESSAGE);
    }
}
