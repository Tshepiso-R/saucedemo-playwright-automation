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
        
        // Get browser type from system property, default to chromium
        String browserType = System.getProperty("browser", "chromium").toLowerCase();
        
        // Launch the specified browser
        switch (browserType) {
            case "firefox":
                browser = playwright.firefox().launch(
                    new BrowserType.LaunchOptions().setHeadless(true)
                );
                System.out.println("Running tests on Firefox");
                break;
                
            case "webkit":
                browser = playwright.webkit().launch(
                    new BrowserType.LaunchOptions().setHeadless(true)
                );
                System.out.println("Running tests on WebKit (Safari)");
                break;
                
            case "chromium":
            default:
                browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(true)
                );
                System.out.println("Running tests on Chromium");
                break;
        }
        
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