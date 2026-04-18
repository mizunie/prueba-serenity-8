package com.ejemplo.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends PageObject {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[name='account'][value='guest']")
    private WebElementFacade guestCheckoutButton;

    @FindBy(id = "button-account")
    private WebElementFacade continueAccountButton;

    @FindBy(id = "input-payment-firstname")
    private WebElementFacade firstNameInput;

    @FindBy(id = "input-payment-lastname")
    private WebElementFacade lastNameInput;

    @FindBy(id = "input-payment-email")
    private WebElementFacade emailInput;

    @FindBy(id = "input-payment-telephone")
    private WebElementFacade telephoneInput;

    @FindBy(id = "input-payment-company")
    private WebElementFacade companyInput;

    @FindBy(id = "input-payment-address-1")
    private WebElementFacade address1Input;

    @FindBy(id = "input-payment-address-2")
    private WebElementFacade address2Input;

    @FindBy(id = "input-payment-city")
    private WebElementFacade cityInput;

    @FindBy(id = "input-payment-postcode")
    private WebElementFacade postcodeInput;

    @FindBy(id = "input-payment-country")
    private WebElementFacade countrySelect;

    @FindBy(id = "input-payment-zone")
    private WebElementFacade zoneSelect;

    @FindBy(id = "button-guest")
    private WebElementFacade continueGuestButton;

    @FindBy(name = "comment")
    private WebElementFacade commentTextarea;

    @FindBy(name = "agree")
    private WebElementFacade termsCheckbox;

    @FindBy(id = "button-payment-method")
    private WebElementFacade continuePaymentMethodButton;

    @FindBy(id = "button-shipping-method")
    private WebElementFacade continueShippingButton;

    @FindBy(xpath = "//td/strong[starts-with(text(),'Total:')]")
    private WebElementFacade totalLabel;

    @FindBy(id = "button-confirm")
    private WebElementFacade confirmOrderButton;

    @FindBy(xpath = "//h1[text()='Your order has been placed!']")
    private WebElementFacade orderPlacedMessage;

    public void openApplication() {
        openAt("http://opencart.abstracta.us/index.php?route=checkout/checkout");
    }

    public void maximizeWindow() {
        getDriver().manage().window().maximize();
    }

    public void clickGuestCheckout() {
        guestCheckoutButton.click();
    }

    public void clickContinueAccount() {
        continueAccountButton.click();
    }

    public void fillFirstName(String value) {
        firstNameInput.type(value);
    }

    public void fillLastName(String value) {
        lastNameInput.type(value);
    }

    public void fillEmail(String value) {
        emailInput.type(value);
    }

    public void fillTelephone(String value) {
        telephoneInput.type(value);
    }

    public void fillCompany(String value) {
        companyInput.type(value);
    }

    public void fillAddress1(String value) {
        address1Input.type(value);
    }

    public void fillAddress2(String value) {
        address2Input.type(value);
    }

    public void fillCity(String value) {
        cityInput.type(value);
    }

    public void fillPostcode(String value) {
        postcodeInput.type(value);
    }

    public void selectCountry(String value) {
        countrySelect.selectByValue(value);
    }

    public void selectZone(String value) {
        zoneSelect.selectByValue(value);
    }

    public void clickContinueGuest() {
        continueGuestButton.click();
    }

    public void fillComment(String value) {
        commentTextarea.type(value);
    }

    public void clickTermsCheckbox() {
        termsCheckbox.click();
    }

    public void clickContinuePaymentMethod() {
        continuePaymentMethodButton.click();
    }

    public void clickContinueShippingButton() {
        continueShippingButton.click();
    }

    public void clickConfirmOrder() {
        confirmOrderButton.click();
    }

    public void waitForTotalVisible() {
        waitForCondition().until(d -> totalLabel.isVisible());
    }

    public void waitForOrderPlacedMessageVisible() {
        waitForCondition().until(d -> orderPlacedMessage.isVisible());
    }

    public WebElementFacade getTotalLabel() {
        return totalLabel;
    }

    public WebElementFacade getOrderPlacedMessage() {
        return orderPlacedMessage;
    }
}