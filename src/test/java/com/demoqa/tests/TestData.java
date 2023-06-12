package com.demoqa.tests;

import com.demoqa.utils.RandomUtils;

import static com.demoqa.utils.RandomUtils.*;

public class TestData {

  public static String
            name = randomFirstName(),
            lastName = randomLastName(),
            userEmail = randomEmail(),
            userGender = randomGender(),
            userNumber = "8800555353",
            userDay = "02",
            userMonth = "November",
            userYear = "1999",
            userSubjects = "Computer Science",
            userHobbies = "Sports",
            imageURL = "selenideLogo.png",
            currentAddress = "94 Smith Ln Bunnell, Florida(FL), 32110",
            userState = "Haryana",
            userCity = "Karnal";
}
