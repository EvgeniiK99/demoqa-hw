package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultTableComponent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    CalendarComponent calendar = new CalendarComponent();
    ResultTableComponent resultTableComponent = new ResultTableComponent();
    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderRadioButton = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsWrapper").$("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            uploadImageButton = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress-wrapper").$("#currentAddress"),
            stateInput = $("#stateCity-wrapper").$("#state"),
            cityInput = $("#stateCity-wrapper").$("#city"),
            submitButton = $("button#submit");

    @Step("Open registration page")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }
    @Step("Remove ads and footer")
    public RegistrationPage removeAdsAndFooter() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    @Step("Set name: {firstName}")
    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }
    @Step("Set lastname: {lastName}")
    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    @Step("Set Email: {userEmail}")
    public RegistrationPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }
    @Step("Set gender: {userGender}")
    public RegistrationPage setUserGender(String userGender) {
        genderRadioButton.$(byText(userGender)).click();
        return this;
    }
    @Step("Set number: {userNumber}")
    public RegistrationPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
        return this;
    }
    @Step("Set date of birth")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendar.setDate(day, month, year);
        return this;
    }
    @Step("Set subject: {subject}")
    public RegistrationPage setSubjects(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }
    @Step("Set hobbies: {hobbies}")
    public RegistrationPage setHobbies(String hobbies) {
        hobbiesInput.$(byText(hobbies)).click();
        return this;
    }
    @Step("Upload image: {imageURL}")
    public RegistrationPage uploadImage(String imageURL) {
        uploadImageButton.uploadFromClasspath(imageURL);
        return this;
    }
    @Step("Set current address: {currentAddress}")
    public RegistrationPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);
        return this;
    }
    @Step("Set State: {state}")
    public RegistrationPage setState(String state) {
        stateInput.click();
        stateInput.$(byText(state)).click();
        return this;
    }
    @Step("Set City: {city}")
    public RegistrationPage setCity(String city) {
        cityInput.click();
        cityInput.$(byText(city)).click();
        return this;
    }
    @Step("Click \"Submit\"")
    public RegistrationPage submit() {
        submitButton.click();
        return this;
    }
    @Step("Check header in table")
    public RegistrationPage checkTableHeader() {
        resultTableComponent.checkHeader("Thanks for submitting the form");
        return this;
    }
    @Step("Check {elementName}")
    public RegistrationPage checkValue(String elementName, String userAddress) {
        resultTableComponent.checkTable(elementName, userAddress);
        return this;
    }
}
