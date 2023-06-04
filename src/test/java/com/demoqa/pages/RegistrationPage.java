package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultTableComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static java.lang.String.format;

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

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage removeAdsAndFooter() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }

    public RegistrationPage setUserGender(String userGender) {
        genderRadioButton.$(byText(userGender)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String hobbies) {
        hobbiesInput.$(byText(hobbies)).click();
        return this;
    }

    public RegistrationPage uploadImage(String imageURL) {
        uploadImageButton.uploadFromClasspath(imageURL);
        return this;
    }

    public RegistrationPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);
        return this;
    }

    public RegistrationPage setState(String state) {
        stateInput.click();
        stateInput.$(byText(state)).click();
        return this;
    }

    public RegistrationPage setCity(String city) {
        cityInput.click();
        cityInput.$(byText(city)).click();
        return this;
    }

    public RegistrationPage submit() {
        submitButton.click();
        return this;
    }

    public RegistrationPage checkTableHeader() {
        resultTableComponent.checkHeader("Thanks for submitting the form");
        return this;
    }

    public RegistrationPage checkName(String name, String lastName) {
        String fullName = format("%s %s", name, lastName);
        resultTableComponent.checkTable("Student Name", fullName);
        return this;
    }

    public RegistrationPage checkEmail(String userEmail) {
        resultTableComponent.checkTable("Student Email", userEmail);
        return this;
    }

    public RegistrationPage checkGender(String userGender) {
        resultTableComponent.checkTable("Gender", userGender);
        return this;
    }

    public RegistrationPage checkNumber(String userNumber) {
        resultTableComponent.checkTable("Mobile", userNumber);
        return this;
    }

    public RegistrationPage checkDateOfBirth(String day, String month, String year) {
        String userDateOfBirth = format("%s %s,%s", day, month, year);
        resultTableComponent.checkTable("Date of Birth", userDateOfBirth);
        return this;
    }

    public RegistrationPage checkSubjects(String userSubjects) {
        resultTableComponent.checkTable("Subjects", userSubjects);
        return this;
    }

    public RegistrationPage checkHobbies(String userHobbies) {
        resultTableComponent.checkTable("Hobbies", userHobbies);
        return this;
    }

    public RegistrationPage checkImage(String imageURL) {
        resultTableComponent.checkTable("Picture", imageURL);
        return this;
    }

    public RegistrationPage checkAddress(String userAddress) {
        resultTableComponent.checkTable("Address", userAddress);
        return this;
    }

    public RegistrationPage checkStateCity(String userState, String userCity) {
        String userStateCity = format("%s %s", userState, userCity);
        resultTableComponent.checkTable("State and City", userStateCity);
        return this;
    }
}
