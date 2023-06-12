package com.demoqa.tests;

import org.junit.jupiter.api.Test;

import static com.demoqa.tests.TestData.*;
import static java.lang.String.format;

public class RegistrationTest extends TestBase {



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