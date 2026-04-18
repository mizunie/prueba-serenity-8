package com.ejemplo.tests;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import com.ejemplo.pages.AddToCartPage;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class AddToCartTest {
    
    @Managed
    WebDriver driver;
    
    AddToCartPage addToCartPage;
    
    @BeforeEach
    void setUp() {
        addToCartPage = new AddToCartPage(driver);
        addToCartPage.openApplication();
    }
    
    @Test
    @Tag("add_to_cart")
    void shouldAddTwoItemsToCart() throws InterruptedException {
        addToCartPage.clickFirstTwoAddToCartButtons();
        addToCartPage.waitForCartCount(2);

        String cartText = addToCartPage.getCartTotalText();
        assertThat(cartText).contains("2 item(s)");
        
        addToCartPage.clickCartTotal();
        addToCartPage.openCheckoutApplication();
        
        String currentUrl = driver.getCurrentUrl();
        assertThat(currentUrl).contains("checkout/checkout");
    }
}