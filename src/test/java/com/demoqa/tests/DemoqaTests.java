package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaTests {
    String name = "Evgenii";
    String lastName = "Klimashin";
    String userEmail = "evgeniik@gmail.com";
    String userNumber = "88005553535";
    String imageURL = "selenideLogo.png";
    String currentAddress = "94 Smith Ln Bunnell, Florida(FL), 32110";
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;

    }
    @Test
    void Demoqa() {
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue(name);
        $("input#lastName").setValue(lastName);
        $("input#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText("Male")).click();
        $("input#userNumber").setValue(userNumber);
        $("div.react-datepicker-wrapper").click();
        $(".react-datepicker__year-select").selectOptionByValue("1999");
        $(".react-datepicker__month-select").selectOptionContainingText("November");
        $("div.react-datepicker__week").$(byText("2")).click();
        $("div#subjectsWrapper").$("#subjectsInput").setValue("computer").pressEnter();
//        $("#hobbiesWrapper").$("label:contains('Sports')").click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("input#uploadPicture").uploadFromClasspath(imageURL);
        $("#currentAddress-wrapper").$("textarea.form-control").setValue(currentAddress);

    }
}
