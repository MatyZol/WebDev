package hu.unideb.runner;

import com.github.javafaker.Faker;
import hu.unideb.model.Book;
import hu.unideb.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.rmi.server.LogStream.log;
@Component
@AllArgsConstructor
@Slf4j
public class BookRunner implements CommandLineRunner {


    private final BookRepository bookRepository;

    private static final Faker FAKER = new Faker();
    private static final String ISBN = "ISBN";




    private String getISBN(){
        return ISBN+" "+FAKER.code().isbn10(true);
    }


    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 100; i++) {
            final var book = bookRepository.save(Book.builder()
                    .ISBN(getISBN())
                    .title(FAKER.book().title())
                    .author(FAKER.book().author())
                    .build());
            log.info(book.toString());
        }
    }
}
