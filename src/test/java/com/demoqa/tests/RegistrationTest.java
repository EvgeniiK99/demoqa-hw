package com.demoqa.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.demoqa.tests.TestData.*;
import static com.demoqa.utils.RandomUtils.*;
import static java.lang.String.format;

public class RegistrationTest extends TestBase {
    @Owner("Klimashin Evgenii")
    @Link(value = "Git repo", url = "https://github.com/EvgeniiK99/demoqa-hw/tree/mainTest2")
    @Feature("Registration demoQA")
    @Story("Successful registration")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Successful registration test, all fields filled")
    @Tag("registration")
    @Test
    void successfulRegistrationDemoqaTest() {
        name = getRandomFirstName();
        lastName = getRandomLastName();
        userEmail = getRandomEmail();
        userGender = getRandomGender();
        userNumber = getRandomNumber();
        userDay = getRandomDay();
        userMonth = getRandomMonth();
        userYear = getRandomYear();
        userSubjects = getRandomSubjects();
        userHobbies = getRandomHobbies();
        imageURL = getRandomImageURL();
        currentAddress = getRandomAddress();
        userState = getRandomState();
        userCity = getRandomCity(userState);
        registrationPage
                .openPage()
                .removeAdsAndFooter()
                .setFirstName(name)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setUserGender(userGender)
                .setUserNumber(userNumber)
                .setDateOfBirth(userDay, userMonth, userYear)
                .setSubjects(userSubjects)
                .setHobbies(userHobbies)
                .uploadImage(imageURL)
                .setCurrentAddress(currentAddress)
                .setState(userState)
                .setCity(userCity)
                .submit()
                .checkTableHeader()
                .checkValue("Student Name", format("%s %s", name, lastName))
                .checkValue("Student Email", userEmail)
                .checkValue("Gender", userGender)
                .checkValue("Mobile", userNumber)
                .checkValue("Date of Birth", format("%s %s,%s", userDay, userMonth, userYear))
                .checkValue("Subjects", userSubjects)
                .checkValue("Hobbies", userHobbies)
                .checkValue("Picture", imageURL)
                .checkValue("Address", currentAddress)
                .checkValue("State and City", format("%s %s", userState, userCity));
    }
}