package com.demoqa.utils;

import com.github.javafaker.Faker;

public class RandomUtils {
    static Faker faker = new Faker();

    public static String randomFirstName(){
       return faker.name().firstName();
    }
    public static String randomLastName(){
        return faker.name().lastName();
    }
    public static String randomEmail() {
        return faker.internet().emailAddress();
    }
    public static String randomGender(){
        String[] genders = {"Male", "Female", "Others"};
        return genders[(int) (Math.random() * (genders.length - 1))];
    }
    public static String randomNumber() {
        return faker.phoneNumber().phoneNumber();

    }
}
