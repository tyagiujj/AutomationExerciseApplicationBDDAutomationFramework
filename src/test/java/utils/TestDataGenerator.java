package utils;

import net.datafaker.Faker;

/**
 * TestDataGenerator class
 * --------------------------
 * Generates random, realistic test data for form fields
 * (name, email, address, etc.) using the Java Faker library.
 * Centralizes all fake-data generation in one place.
 */
public class TestDataGenerator {

    private static Faker faker = new Faker();

    public static String getRandomName() {
        return faker.name().fullName();
    }

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    // Unique email using Faker + timestamp (guarantees no duplicates)
    public static String getRandomEmail() {
        String baseEmail = faker.name().username();
        long timestamp = System.currentTimeMillis();
        return baseEmail + timestamp + "@example.com";
    }

    public static String getRandomPassword() {
        return faker.internet().password(8, 12); // 8-12 characters long
    }

    public static String getRandomCompany() {
        return faker.company().name();
    }

    public static String getRandomAddress() {
        return faker.address().streetAddress();
    }

    public static String getRandomCity() {
        return faker.address().city();
    }

    public static String getRandomState() {
        return faker.address().state();
    }

    public static String getRandomZipCode() {
        return faker.address().zipCode();
    }

    public static String getRandomMobileNumber() {
        return faker.phoneNumber().phoneNumber();
    }
}