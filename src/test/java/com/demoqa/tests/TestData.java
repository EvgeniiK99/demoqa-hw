package com.demoqa.tests;


import static com.demoqa.utils.RandomUtils.*;

public class TestData {

    public static String
            name = getRandomFirstName(),
            lastName = getRandomLastName(),
            userEmail = getRandomEmail(),
            userGender = getRandomGender(),
            userNumber = getRandomNumber(),
            userDay = getRandomDay(),
            userMonth = getRandomMonth(),
            userYear = getRandomYear(),
            userSubjects = getRandomSubjects(),
            userHobbies = getRandomHobbies(),
            imageURL = getRandomImageURL(),
            currentAddress = getRandomAddress(),
            userState = getRandomState(),
            userCity = getRandomCity(userState);
}
