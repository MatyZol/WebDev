package hu.unideb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static final Random RANDOM = new Random();

    private static final String LETTERS = "ABCDEFGHIJKLMNOP";
    private static final String DIGITS = "0123456789";

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);


    }
}
