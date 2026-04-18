package com.ejemplo.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class AddToCartPage extends PageObject {

  public AddToCartPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//span[text()='Add to Cart']")
  private List<WebElementFacade> addToCartButtons;

  @FindBy(id = "cart-total")
  private WebElementFacade cartTotal;

  @FindBy(xpath = "//p[@class='price']")
  private List<WebElementFacade> priceElements;

  public void openApplication() {
    openAt("http://opencart.abstracta.us/index.php");
  }

  public void openCheckoutApplication() {
    openAt("http://opencart.abstracta.us/index.php?route=checkout/checkout");
  }

  public void clickFirstTwoAddToCartButtons() {
    if (addToCartButtons.size() >= 2) {
      addToCartButtons.get(0).click();
      addToCartButtons.get(1).click();
    }
  }

  public String getFullPriceFromFirstProduct() {
    if (!priceElements.isEmpty()) {
      String fullText = priceElements.get(0).getText();
      String[] lines = fullText.split("\n");
      return lines[0].trim();
    }
    return "";
  }

  public String getExTaxFromFirstProduct() {
    if (!priceElements.isEmpty()) {
      String fullText = priceElements.get(0).getText();
      String[] lines = fullText.split("\n");
      if (lines.length > 1) {
        return lines[1].trim();
      }
    }
    return "";
  }

  public void clickCartTotal() {
    cartTotal.click();
  }

  public void waitForCartCount(int count) {
    waitForCondition().until(d -> {
      try {
        return $("#cart-total").getText().contains(count + " item");
      } catch (org.openqa.selenium.StaleElementReferenceException e) {
        return false;
      }
    });
  }

  public String getCartTotalText() {
    return cartTotal.getText();
  }
}