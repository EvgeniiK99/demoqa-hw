package com.demoqa.utils;

import com.github.javafaker.Faker;

import java.time.Year;
import java.util.Random;

public class RandomUtils {

    static Faker faker = new Faker();
    static Random random = new Random();
    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public static String getRandomNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String getRandomDay() {

        int randomInt = random.nextInt(28) + 1;
        String selectedDay;
        if (randomInt <= 9) {
            selectedDay = "0" + randomInt;
        } else {
            selectedDay = String.valueOf(randomInt);
        }
        return selectedDay;
    }

    public static String getRandomMonth() {
        return faker.options().option("January", "February", "March",
                "April", "May", "June",
                "July", "August", "September",
                "October", "November", "December");
    }

    public static String getRandomYear() {
        int nowYear = Integer.parseInt(String.valueOf(Year.now()));
        return String.valueOf(faker.number().numberBetween(1920, nowYear - 1));
    }

    public static String getRandomSubjects() {
        return faker.options().option("Computer Science", "English", "Economics");
    }

    public static String getRandomHobbies() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public static String getRandomImageURL() {
        return faker.options().option("selenideLogo.png", "googleLogo.png");
    }

    public static String getRandomAddress() {
        return faker.address().fullAddress();
    }

    public static String getRandomState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana");
    }

    public static String getRandomCity(String state) {
        if (state == "NCR") {
            return faker.options().option("Delhi", "Gurgaon", "Noida");
        } else if (state == "Uttar Pradesh") {
            return faker.options().option("Agra", "Lucknow", "Merrut");
        } else {
            return faker.options().option("Karnal", "Panipat");
        }
    }
}
