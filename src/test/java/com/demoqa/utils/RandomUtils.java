package com.demoqa.utils;

import com.github.javafaker.Faker;

import java.time.Year;
import java.util.Random;

public class RandomUtils {

    static Faker faker = new Faker();
    static Random random = new Random();

    public static int randomInt(String[] array) {
        return (int) (Math.random() * (array.length));
    }

    public static String randomFirstName() {
        return faker.name().firstName();
    }

    public static String randomLastName() {
        return faker.name().lastName();
    }

    public static String randomEmail() {
        return faker.internet().emailAddress();
    }

    public static String randomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return genders[randomInt(genders)];
    }

    public static String randomNumber() {
        String randomNumber = "";
        for (int i = 0; i <= 9; i++) {
            randomNumber += String.valueOf(random.nextInt(0, 9));
        }
        return randomNumber;
    }

    public static String randomDay() {

        int randomInt = random.nextInt(28) + 1;
        String selectedDay;
        if (randomInt <= 9) {
            selectedDay = "0" + randomInt;
        } else {
            selectedDay = String.valueOf(randomInt);
        }
        return selectedDay;
    }

    public static String randomMonth() {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return months[randomInt(months)];
    }

    public static String randomYear() {
        int nowYear = Integer.parseInt(String.valueOf(Year.now()));
        return String.valueOf(faker.number().numberBetween(1920, nowYear - 1));
    }

    public static String randomSubjects() {
        String[] hobbies = {"Computer Science", "English", "Economics"};
        return hobbies[randomInt(hobbies)];
    }

    public static String randomHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return hobbies[randomInt(hobbies)];
    }

    public static String randomImageURL() {
        String[] imageURL = {"selenideLogo.png", "googleLogo.png"};
        return imageURL[randomInt(imageURL)];
    }

    public static String randomAddress() {
        return faker.address().fullAddress();
    }

    public static String randomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana"};
        return states[randomInt(states)];
    }

    public static String randomCity(String state) {
        String[] citiesNCR = {"Delhi", "Gurgaon", "Noida"};
        String[] citiesUP = {"Agra", "Lucknow", "Merrut"};
        String[] citiesHaryana = {"Karnal", "Panipat"};
        String selectedCity;
        if (state == "NCR") {
            selectedCity = citiesNCR[randomInt(citiesNCR)];
        } else if (state == "Uttar Pradesh") {
            selectedCity = citiesUP[randomInt(citiesUP)];
        } else {
            selectedCity = citiesHaryana[randomInt(citiesHaryana)];
        }
        return selectedCity;
    }
}
