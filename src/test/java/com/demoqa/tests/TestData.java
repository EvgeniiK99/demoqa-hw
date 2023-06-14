package com.demoqa.tests;


import static com.demoqa.utils.RandomUtils.*;

public class TestData {

    public static String
            name = randomFirstName(),
            lastName = randomLastName(),
            userEmail = randomEmail(),
            userGender = randomGender(),
            userNumber = randomNumber(),
            userDay = randomDay(),
            userMonth = randomMonth(),
            userYear = randomYear(),
            userSubjects = randomSubjects(),
            userHobbies = randomHobbies(),
            imageURL = randomImageURL(),
            currentAddress = randomAddress(),
            userState = randomState(),
            userCity = randomCity(userState);
}
