package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoqaTests {
    String name = "Evgenii";
    String lastName = "Klimashin";
    String userEmail = "evgeniik@gmail.com";
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }
    @Test
    void Demoqa() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(name);
        $("input#lastName").setValue(lastName);
        $("input#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText("Male")).click();
    }
}
