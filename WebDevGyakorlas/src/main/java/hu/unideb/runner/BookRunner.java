package hu.unideb.runner;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BookRunner implements CommandLineRunner {

    private static final Faker FAKER = new Faker();
    private static final Random RANDOM = new Random();
    private static final String DIGITS = "0123456789";
    private static final String ISBN = "ISBN";

    private static String getISBN(){
        return "";
    }


    @Override
    public void run(String... args) throws Exception {

    }
}
