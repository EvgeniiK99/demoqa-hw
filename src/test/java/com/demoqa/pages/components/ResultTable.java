package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class ResultTable {
    SelenideElement
            header = $(".modal-header"),
            resultTable = $(".table-responsive"),
            studentName = resultTable.find(byText("Student Name")).sibling(0),
            studentEmail = resultTable.find(byText("Student Email")).sibling(0),
            studentGender = resultTable.find(byText("Gender")).sibling(0),
            studentNumber = resultTable.find(byText("Mobile")).sibling(0),
            studentDateOfBirth = resultTable.find(byText("Date of Birth")).sibling(0),
            studentSubjects = resultTable.find(byText("Subjects")).sibling(0),
            studentHobbies = resultTable.find(byText("Hobbies")).sibling(0),
            uploadedImageURL = resultTable.find(byText("Picture")).sibling(0),
            studentAddress = resultTable.find(byText("Address")).sibling(0),
            studentStateCity = resultTable.find(byText("State and City")).sibling(0);

    public void checkHeader(String textHeader) {
        header.shouldHave(text(textHeader));
    }

    public void checkName(String name, String lastName) {
        studentName.shouldHave(text(format("%s %s", name, lastName)));
    }

    public void checkEmail(String userEmail) {
        studentEmail.shouldHave(text(userEmail));
    }

    public void checkGender(String userGender) {
        studentGender.shouldHave(text(userGender));
    }

    public void checkNumber(String userNumber) {
        studentNumber.shouldHave(text(userNumber));
    }

    public void checkDateOfBirth(String userDateOfBirth) {
        studentDateOfBirth.shouldHave(text(userDateOfBirth));
    }

    public void checkSubjects(String userSubjects) {
        studentSubjects.shouldHave(text(userSubjects));
    }

    public void checkHobbies(String userHobbies) {
        studentHobbies.shouldHave(text(userHobbies));
    }

    public void checkImage(String imageURL) {
        uploadedImageURL.shouldHave(text(imageURL));
    }

    public void checkAddress(String userAddress) {
        studentAddress.shouldHave(text(userAddress));
    }

    public void checkStateCity(String userStateCity) {
        studentStateCity.shouldHave(text(userStateCity));
    }
}
