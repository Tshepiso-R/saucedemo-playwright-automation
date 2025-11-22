package com.sdet.tests;

import com.microsoft.playwright.*;
import org.testng.annotations.*;

public class BaseTest {
    
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeMethod
    public void setUp() {
        playwright = Playwright.create();
        
        browser = playwright.chromium().launch(
            new BrowserType.LaunchOptions().setHeadless(true)
        );
        
        context = browser.newContext(
            new Browser.NewContextOptions()
                .setViewportSize(1920, 1080)
        );
        
        page = context.newPage();
    }

    @AfterMethod
    public void tearDown() {
        if (page != null) page.close();
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}
