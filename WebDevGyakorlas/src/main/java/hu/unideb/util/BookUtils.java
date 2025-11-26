package hu.unideb.util;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BookUtils {
    public static final Faker FAKER = new Faker();
    public static final String ISBN = "ISBN";
    public static final Random RANDOM = new Random();

    public String[] genres = {"Regény", "Sci-fi", "Fantasy", "Krimi", "Thriller", "Romantikus", "Történelmi", "Életrajz", "Ismeretterjesztő", "Horror", "Ifjúsági", "Novella", "Kaland", "Dráma"};


    public BookUtils() {
    }

    public  String getISBN() {
        return ISBN + " " + FAKER.code().isbn10(true);
    }

    public  int getPrice() {
        return RANDOM.nextInt(5, 100);
    }

    public  int getPageNumber() {
        return RANDOM.nextInt(50,1000);
    }

    public String getGenre(){
        int random = RANDOM.nextInt(0,genres.length-1);
        return genres[random];
    }
}