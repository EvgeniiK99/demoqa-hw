package com.demoqa.tests;

import org.junit.jupiter.api.Test;

public class RegistrationTest extends TestBase {

    String name = "Evgenii",
            lastName = "Klimashin",
            userEmail = "evgeniik@gmail.com",
            userGender = "Male",
            userNumber = "8800555353",
            userDay = "02",
            userMonth = "November",
            userYear = "1999",
            userSubjects = "Computer Science",
            userHobbies = "Sports",
            imageURL = "selenideLogo.png",
            currentAddress = "94 Smith Ln Bunnell, Florida(FL), 32110",
            userState = "Haryana",
            userCity = "Karnal";

    @Test
    void demoqa() {
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
                .checkName(name, lastName)
                .checkEmail(userEmail)
                .checkGender(userGender)
                .checkNumber(userNumber)
                .checkDateOfBirth(userDay, userMonth, userYear)
                .checkSubjects(userSubjects)
                .checkHobbies(userHobbies)
                .checkImage(imageURL)
                .checkAddress(currentAddress)
                .checkStateCity(userState, userCity);
    }
}