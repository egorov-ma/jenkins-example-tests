package ru.egorovma.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class RandomDateGenerator {

    private final Random random;
    private final DateTimeFormatter fullFormatter;
    private final LocalDate generatedDate;

    public RandomDateGenerator(int minYear, int maxYear) {
        this.random = new Random();
        this.fullFormatter = DateTimeFormatter.ofPattern("dd MMMM,yyyy", Locale.ENGLISH);
        this.generatedDate = generateRandomDate(minYear, maxYear);
    }

    private LocalDate generateRandomDate(int minYear, int maxYear) {
        int minDay = (int) LocalDate.of(minYear, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(maxYear, 12, 31).toEpochDay();
        int randomDay = minDay + random.nextInt(maxDay - minDay + 1);
        return LocalDate.ofEpochDay(randomDay);
    }

    public String getRandomDay() {
        return String.valueOf(generatedDate.getDayOfMonth());
    }

    public String getRandomMonth() {
        return generatedDate.format(DateTimeFormatter.ofPattern("MMMM", Locale.ENGLISH));
    }

    public String getRandomYear() {
        return String.valueOf(generatedDate.getYear());
    }

    public String getCustomFormattedDate() {
        return generatedDate.format(fullFormatter);
    }
}