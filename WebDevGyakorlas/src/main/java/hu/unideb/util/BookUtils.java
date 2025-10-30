package hu.unideb.util;

import com.github.javafaker.Faker;

import java.util.Random;

public class BookUtils {
    public static final Faker FAKER = new Faker();
    public static final String ISBN = "ISBN";
    public static final Random RANDOM = new Random();

    public BookUtils() {
    }

    public static String getISBN() {
        return ISBN + " " + FAKER.code().isbn10(true);
    }

    public static int getPrice() {
        return RANDOM.nextInt(5, 100);
    }
}