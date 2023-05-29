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
    void Demoqa() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(name);
        $("input#lastName").setValue(lastName);
        $("input#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("input#userNumber").setValue(userNumber);

        $("div.react-datepicker-wrapper").click();
        $(".react-datepicker__year-select").selectOptionByValue("1999");
        $(".react-datepicker__month-select").selectOptionContainingText("November");
        $("div.react-datepicker__week").$(byText("2")).click();

        $("div#subjectsWrapper").$("#subjectsInput").setValue("computer").pressEnter();

        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("input#uploadPicture").uploadFromClasspath(imageURL);
        $("#currentAddress-wrapper").$("textarea.form-control").setValue(currentAddress);

        $("div#stateCity-wrapper").$("div#state").click();
        $("div#stateCity-wrapper").$("div#state").$(byText("Uttar Pradesh")).click();

        $("div#stateCity-wrapper").$("div#city").click();
        $("div#stateCity-wrapper").$("div#city").$(byText("Agra")).click();

        $("button#submit").click();

        $("div.modal-header").shouldHave(text("Thanks for submitting the form"));
        $("div.table-responsive").find(byText("Student Name")).sibling(0).shouldHave(text(name + " " + lastName));
        $("div.table-responsive").find(byText("Student Email")).sibling(0).shouldHave(text(userEmail));
        $("div.table-responsive").find(byText("Gender")).sibling(0).shouldHave(text(gender));
        $("div.table-responsive").find(byText("Mobile")).sibling(0).shouldHave(text(userNumber));
        $("div.table-responsive").find(byText("Gender")).sibling(0).shouldHave(text(gender));
        $("div.table-responsive").find(byText("Date of Birth")).sibling(0).shouldHave(text("02 November,1999"));
        $("div.table-responsive").find(byText("Subjects")).sibling(0).shouldHave(text("Computer Science"));
        $("div.table-responsive").find(byText("Hobbies")).sibling(0).shouldHave(text("Sports"));
        $("div.table-responsive").find(byText("Picture")).sibling(0).shouldHave(text(imageURL));
        $("div.table-responsive").find(byText("Address")).sibling(0).shouldHave(text(currentAddress));
        $("div.table-responsive").find(byText("State and City")).sibling(0).shouldHave(text("Uttar Pradesh Agra"));

        $("button#closeLargeModal").click();
    }
}