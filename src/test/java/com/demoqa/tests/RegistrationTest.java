package com.demoqa.tests;

import org.junit.jupiter.api.Test;

import static java.lang.String.format;

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