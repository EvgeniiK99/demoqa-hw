package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {
    SelenideElement
            header = $(".modal-header"),
            resultTable = $(".table-responsive");

    public void checkHeader(String value) {
        header.shouldHave(text(value));
    }

    public void checkTable(String elementName, String value) {
        resultTable.find(byText(elementName)).sibling(0).shouldHave(text(value));
    }
}
