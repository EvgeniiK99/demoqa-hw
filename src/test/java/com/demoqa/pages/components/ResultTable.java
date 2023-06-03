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
            studentName = resultTable.find(byText("Student Name")),
            studentEmail = resultTable.find(byText("Student Email")),
            studentGender = resultTable.find(byText("Gender")),
            studentNumber = resultTable.find(byText("Mobile")),
            studentDateOfBirth = resultTable.find(byText("Date of Birth")),
            studentSubjects = resultTable.find(byText("Subjects")),
            studentHobbies = resultTable.find(byText("Hobbies")),
            uploadedImageURL = resultTable.find(byText("Picture")),
            studentAddress = resultTable.find(byText("Address")),
            studentStateCity= resultTable.find(byText("State and City"));



    public ResultTable checkHeader (String textHeader) {
        header.shouldHave(text(textHeader));
        return this;
    }

    public ResultTable checkName (String name, String lastName) {
        studentName.sibling(0).shouldHave(text(format("%s %s", name, lastName)));
        return this;
    }
    public ResultTable checkEmail(String userEmail) {
        studentEmail.sibling(0).shouldHave(text(userEmail));
        return this;
    }
    public ResultTable checkGender(String userGender) {
        studentGender.sibling(0).shouldHave(text(userGender));
        return this;
    }
    public ResultTable checkNumber(String userNumber) {
        studentNumber.sibling(0).shouldHave(text(userNumber));
        return this;
    }
    public ResultTable checkDateOfBirth(String userDateOfBirth) {
        studentDateOfBirth.sibling(0).shouldHave(text(userDateOfBirth));
        return this;
    }
    public ResultTable checkSubjects(String userSubjects) {
        studentSubjects.sibling(0).shouldHave(text(userSubjects));
        return this;
    }


//      .shouldHave(text("Thanks for submitting the form"));

//    .sibling(0).shouldHave(text("02 November,1999"));
//   .find(byText("Subjects")).sibling(0).shouldHave(text("Computer Science"));
//    .find(byText("Hobbies")).sibling(0).shouldHave(text("Sports"));
//   .find(byText("Picture")).sibling(0).shouldHave(text(imageURL));
//    .find(byText("Address")).sibling(0).shouldHave(text(currentAddress));
//   .find(byText("State and City")).sibling(0).shouldHave(text(format("%s %s", state, city)));
}
