package ru.egorovma.data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestDataForStudentRegistrationForm {
    private final Faker faker = new Faker(new Locale("en"));
    private final Faker fakerRu = new Faker(new Locale("ru"));
    private final RandomDateGenerator dateOfBirthGenerator = new RandomDateGenerator(1900, 2100);
    public final static String TOOLS_QA_URL = "/automation-practice-form";
    public final static String CSS_EXPECTED_VALUE = "rgb(220, 53, 69)";
    public String firstName, lastName, fullName, userNumber, address;
    public String emailAddress = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            dayBirth = dateOfBirthGenerator.getRandomDay(),
            monthBirth = dateOfBirthGenerator.getRandomMonth(),
            yearBirth = dateOfBirthGenerator.getRandomYear(),
            dateOfBirth = dateOfBirthGenerator.getCustomFormattedDate(),
            subjects = faker.options().option("Accounting", "Biology", "Chemistry", "English", "Hindi", "Maths", "Physics"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            picture = faker.options().option("test_data/qaguru0.jpg", "test_data/qaguru1.jpg", "test_data/qaguru2.jpg"),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = getRandomCity(state),
            stateAndCity = state + " " + city;

    public TestDataForStudentRegistrationForm(String language) {
        if ("ru".equalsIgnoreCase(language)) {
            firstName = fakerRu.name().firstName();
            lastName = fakerRu.name().lastName();
            fullName = firstName + " " + lastName;
            userNumber = fakerRu.numerify("79########");
            address = fakerRu.address().streetAddress();
        } else {
            firstName = faker.name().firstName();
            lastName = faker.name().lastName();
            fullName = firstName + " " + lastName;
            userNumber = faker.numerify("01########");
            address = fakerRu.address().streetAddress();
        }
    }

//    не годится для jdk11 ((
//    private String getRandomCity(String state) {
//        return switch (state) {
//            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
//            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
//            case "Haryana" -> faker.options().option("Karnal", "Panipat");
//            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
//            default -> throw new IllegalArgumentException("Unsupported state: " + state);
//        };
//    }

    private String getRandomCity(String state) {
        switch (state) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana":
                return faker.options().option("Karnal", "Panipat");
            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");
            default:
                throw new IllegalStateException("Unexpected value: " + state);
        }
    }
}