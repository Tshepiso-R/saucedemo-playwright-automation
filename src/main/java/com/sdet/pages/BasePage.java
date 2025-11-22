package com.sdet.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class BasePage {
    protected Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    public void navigateTo(String url) {
        page.navigate(url);
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
    }

    public String getTitle() {
        return page.title();
    }

    public String getCurrentUrl() {
        return page.url();
    }

    public void waitForElement(String selector) {
        page.waitForSelector(selector);
    }

    public boolean isElementVisible(String selector) {
        return page.isVisible(selector);
    }

    public String getElementText(String selector) {
        return page.textContent(selector);
    }
}
