package com.sdet.tests;

import com.sdet.pages.*;
import com.sdet.utils.TestDataReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemoSmokeTests extends BaseTest {

    @Test(priority = 1, description = "Verify successful login")
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateToLoginPage();
        
        String username = TestDataReader.get("valid.username");
        String password = TestDataReader.get("valid.password");
        
        ProductsPage productsPage = loginPage.login(username, password);
        
        Assert.assertTrue(productsPage.isProductsPageDisplayed());
    }

    @Test(priority = 2, description = "Verify products are displayed")
    public void testProductsDisplayed() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateToLoginPage();
        
        String username = TestDataReader.get("valid.username");
        String password = TestDataReader.get("valid.password");
        
        ProductsPage productsPage = loginPage.login(username, password);
        
        Assert.assertEquals(productsPage.getInventoryItemsCount(), 6);
    }

    @Test(priority = 3, description = "Verify add to cart")
    public void testAddProductToCart() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateToLoginPage();
        
        String username = TestDataReader.get("valid.username");
        String password = TestDataReader.get("valid.password");
        
        ProductsPage productsPage = loginPage.login(username, password);
        productsPage.addFirstProductToCart();
        
        Assert.assertEquals(productsPage.getCartBadgeCount(), "1");
    }

    @Test(priority = 4, description = "Verify checkout process")
    public void testCompleteCheckout() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateToLoginPage();
        
        String username = TestDataReader.get("valid.username");
        String password = TestDataReader.get("valid.password");
        String firstName = TestDataReader.get("checkout.firstname");
        String lastName = TestDataReader.get("checkout.lastname");
        String zipCode = TestDataReader.get("checkout.zipcode");
        
        ProductsPage productsPage = loginPage.login(username, password);
        productsPage.addFirstProductToCart();
        
        CartPage cartPage = productsPage.clickShoppingCart();
        CheckoutPage checkoutPage = cartPage.clickCheckout();
        checkoutPage.completeCheckout(firstName, lastName, zipCode);
        
        Assert.assertTrue(checkoutPage.isOrderComplete());
    }
}