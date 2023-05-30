package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaTests {
    String name = "Evgenii";
    String lastName = "Klimashin";
    String userEmail = "evgeniik@gmail.com";
    String gender = "Male";
    String userNumber = "8800555353";
    String imageURL = "selenideLogo.png";
    String currentAddress = "94 Smith Ln Bunnell, Florida(FL), 32110";

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;

    }
    @Test
    void demoqa() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(name);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(userNumber);

        $(".react-datepicker-wrapper").click();
        $(".react-datepicker__year-select").selectOptionByValue("1999");
        $(".react-datepicker__month-select").selectOptionContainingText("November");
        $(".react-datepicker__week").$(byText("2")).click();

        $("#subjectsWrapper").$("#subjectsInput").setValue("computer").pressEnter();

        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath(imageURL);
        $("#currentAddress-wrapper").$("#currentAddress").setValue(currentAddress);

        $("#stateCity-wrapper").$("#state").click();
        $("#stateCity-wrapper").$("#state").$(byText("Uttar Pradesh")).click();

        $("#stateCity-wrapper").$("#city").click();
        $("#stateCity-wrapper").$("#city").$(byText("Agra")).click();

        $("button#submit").click();

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
        $(".table-responsive").find(byText("State and City")).sibling(0).shouldHave(text("Uttar Pradesh Agra"));
    }
}