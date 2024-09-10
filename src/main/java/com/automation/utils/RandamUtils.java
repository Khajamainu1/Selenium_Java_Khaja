package com.automation.utils;

import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class RandamUtils {

    private RandamUtils() {}


    private static final Faker faker =new Faker();

    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String getUserName() {
        String firstName = faker.name().firstName();
        int maxDigits = Math.max(0, 11 - firstName.length());
        String numericPart = faker.numerify("#".repeat(maxDigits));
        return firstName + numericPart;
    }

    public static String getEmail() {
        Random rand = new Random();
        String fname = faker.name().firstName();
        String lname = faker.name().lastName();
        String[] emailDomains = {"@gmail.com", "@yahoo.com", "@hotmail.com", "@outlook.com", "@icloud.com"};
        String selectedDomain = emailDomains[rand.nextInt(emailDomains.length)];
        String email = fname + lname + rand.nextInt(99999) + selectedDomain;
        return email;
    }

    public static String getStreet() {
        return faker.address().streetAddress();
    }

    public static String getCity() {
        return faker.address().cityName();
    }

    public static String getNumber() {
        return faker.numerify("###");
    }

    public static String getRandomString() {
        return faker.regexify("[A-Za-z0-9]{20}");
    }

    public static String getCommissionRuleName() {
        return "CommissionRule"+faker.numerify("###");
    }

    public static String getmobileNumber() {
        return faker.numerify("##########");
    }

    public static String getCurrentDatetermination() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
















}
