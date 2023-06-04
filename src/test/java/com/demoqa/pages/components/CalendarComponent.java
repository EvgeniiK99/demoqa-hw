package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class CalendarComponent {
    SelenideElement
            openDatePicker = $(".react-datepicker-wrapper"),
            dayInput = $(".react-datepicker__week"),
            monthInput = $(".react-datepicker__month-select"),
            yearInput = $(".react-datepicker__year-select");

    public void setDate(String day, String month, String year) {
        openDatePicker.click();
        yearInput.selectOptionByValue(year);
        monthInput.selectOptionContainingText(month);
        dayInput.$(format(".react-datepicker__day--0%s:not(react-datepicker__day--outside-month)", day)).click();
    }
}
