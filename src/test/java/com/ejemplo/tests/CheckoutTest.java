package com.ejemplo.tests;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import com.ejemplo.pages.AddToCartPage;
import com.ejemplo.pages.CheckoutPage;

import net.serenitybdd.annotations.Managed;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class CheckoutTest {

  @Managed
  WebDriver driver;

  CheckoutPage page;
  AddToCartPage addToCartPage;

  @BeforeEach
  void setUp() {
    addToCartPage = new AddToCartPage(driver);
    page = new CheckoutPage(driver);

    addToCartPage.openApplication();

    addToCartPage.clickFirstTwoAddToCartButtons();
    addToCartPage.waitForCartCount(2);

    page.openApplication();
  }

  @Test
  @Tag("checkout")
  void shouldCompleteCheckoutProcess() {
    page.clickGuestCheckout();
    page.clickContinueAccount();
    page.fillFirstName("Nombre");
    page.fillLastName("Apellido");
    page.fillEmail("correo@example.com");
    page.fillTelephone("573001112233");
    page.fillCompany("Opencart");
    page.fillAddress1("Calle 123");
    page.fillAddress2("Avenida 8");
    page.fillCity("Ciudad");
    page.fillPostcode("604444");
    page.selectCountry("47");
    page.selectZone("747");
    page.clickContinueGuest();
    page.fillComment("Comentario para el textarea");
    page.clickContinueShippingButton();
    page.fillComment("Comentario para el textarea");
    page.clickTermsCheckbox();
    page.clickContinuePaymentMethod();
    page.waitForTotalVisible();
    assertThat(page.getTotalLabel().isVisible()).isTrue();
    page.clickConfirmOrder();
    page.waitForOrderPlacedMessageVisible();
    assertThat(page.getOrderPlacedMessage().isVisible()).isTrue();
  }
}