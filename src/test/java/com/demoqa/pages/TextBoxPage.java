package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {
    SelenideElement
            fullNameInput = $("#userName-wrapper").$("#userName"),
            emailInput = $("#userEmail-wrapper").$("#userEmail"),
            currentAddressInput = $("#currentAddress-wrapper").$("#currentAddress"),
            permanentAddressInput = $("#permanentAddress-wrapper").$("#permanentAddress"),
            submitButton = $("#submit"),
            nameResult = $("#output #name"),
            emailResult = $("#output #email"),
            currentAddressResult = $("#output #currentAddress"),
            permanentAddressResult = $("#output #permanentAddress");

    public TextBoxPage openPage() {
        open("/text-box");
        return this;
    }
    public TextBoxPage removeAdsAndFooter() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setFullName(String fullName) {
        fullNameInput.setValue(fullName);
        return this;
    }

    public TextBoxPage setEmail(String userEmail) {
        emailInput.setValue(userEmail);
        return this;
    }

    public TextBoxPage setCurrentAddress(String userCurrentAddress) {
        currentAddressInput.setValue(userCurrentAddress);
        return this;
    }

    public TextBoxPage setPermanentAddress(String userPermanentAddress) {
        permanentAddressInput.setValue(userPermanentAddress);
        return this;
    }

    public TextBoxPage submit() {
        submitButton.click();
        return this;
    }

    public void checkResult(String name, String email, String currentAddress, String permanentAddress) {
        nameResult.shouldHave(text(name));
        emailResult.shouldHave(text(email));
        currentAddressResult.shouldHave(text(currentAddress));
        permanentAddressResult.shouldHave(text(permanentAddress));
    }

}
