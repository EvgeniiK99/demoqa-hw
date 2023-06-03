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
                .submit();


        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").find(byText("Student Name")).sibling(0).shouldHave(text(name + " " + lastName));
        $(".table-responsive").find(byText("Student Email")).sibling(0).shouldHave(text(userEmail));
        $(".table-responsive").find(byText("Gender")).sibling(0).shouldHave(text(gender));
        $(".table-responsive").find(byText("Mobile")).sibling(0).shouldHave(text(userNumber));
        $(".table-responsive").find(byText("Gender")).sibling(0).shouldHave(text(gender));
        $(".table-responsive").find(byText("Date of Birth")).sibling(0).shouldHave(text("02 November,1999"));
        $(".table-responsive").find(byText("Subjects")).sibling(0).shouldHave(text("Computer Science"));
        $(".table-responsive").find(byText("Hobbies")).sibling(0).shouldHave(text("Sports"));
        $(".table-responsive").find(byText("Picture")).sibling(0).shouldHave(text(imageURL));
        $(".table-responsive").find(byText("Address")).sibling(0).shouldHave(text(currentAddress));
        $(".table-responsive").find(byText("State and City")).sibling(0).shouldHave(text(format("%s %s", state, city)));
    }
}