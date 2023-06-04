package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultTable;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static java.lang.String.format;

public class RegistrationPage {
    CalendarComponent calendar = new CalendarComponent();
    ResultTable resultTable = new ResultTable();
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
        resultTable.checkHeader("Thanks for submitting the form");
        return this;
    }

    public RegistrationPage checkName(String name, String lastName) {
        resultTable.checkName(name, lastName);
        return this;
    }

    public RegistrationPage checkEmail(String userEmail) {
        resultTable.checkEmail(userEmail);
        return this;
    }

    public RegistrationPage checkGender(String userGender) {
        resultTable.checkGender(userGender);
        return this;
    }

    public RegistrationPage checkNumber(String userNumber) {
        resultTable.checkNumber(userNumber);
        return this;
    }

    public RegistrationPage checkDateOfBirth(String day, String month, String year) {
        String userDateOfBirth = format("%s %s,%s", day, month, year);
        resultTable.checkDateOfBirth(userDateOfBirth);
        return this;
    }

    public RegistrationPage checkSubjects(String userSubjects) {
        resultTable.checkSubjects(userSubjects);
        return this;
    }

    public RegistrationPage checkHobbies(String userHobbies) {
        resultTable.checkHobbies(userHobbies);
        return this;
    }

    public RegistrationPage checkImage(String imageURL) {
        resultTable.checkImage(imageURL);
        return this;
    }

    public RegistrationPage checkAddress(String userAddress) {
        resultTable.checkAddress(userAddress);
        return this;
    }

    public RegistrationPage checkStateCity(String userState, String userCity) {
        String userStateCity = format("%s %s", userState, userCity);
        resultTable.checkStateCity(userStateCity);
        return this;
    }
}