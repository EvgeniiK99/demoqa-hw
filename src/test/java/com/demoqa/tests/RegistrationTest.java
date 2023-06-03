package com.demoqa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class RegistrationTest extends TestBase {

    String name = "Evgenii",
            lastName = "Klimashin",
            userEmail = "evgeniik@gmail.com",
            gender = "Male",
            userNumber = "8800555353",
            imageURL = "selenideLogo.png",
            currentAddress = "94 Smith Ln Bunnell, Florida(FL), 32110",
            state = "Haryana",
            city = "Karnal";


    @Test
    void demoqa() {
        registrationPage
                .openPage()
                .setFirstName(name)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setUserGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth("2", "November", "1999")
                .setSubjects("computer")
                .setHobbies("Sports")
                .uploadImage(imageURL)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submit()
                .checkName(name, lastName)
                .checkEmail(userEmail)
                .checkNumber(userNumber);
//                .checkGender(gender);





    }
}