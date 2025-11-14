package hu.unideb.runner;

import com.github.javafaker.Faker;
import hu.unideb.model.Author;
import hu.unideb.model.Book;
import hu.unideb.repository.AuthorRepository;
import hu.unideb.repository.BookRepository;
import hu.unideb.util.BookUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Component
@AllArgsConstructor
@Slf4j
public class BookAuthorRunner implements CommandLineRunner {


    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    private static DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    private static final Faker FAKER = new Faker();
    private final BookUtils bookUtils = new BookUtils();

    @Override
    public void run(String... args) throws Exception {

        for (int i = 0; i < 100; i++) {


        final var author = Author.builder()
                .firstName(FAKER.name().firstName())
                .lastName(FAKER.name().lastName())
                .dateOfBirth(formatter.format(FAKER.date().birthday()))
                //.dateOfBirth(FAKER.date().birthday().toInstant().atOffset(ZoneOffset.UTC))
                .build();

        final var book =  Book.builder()
                    .ISBN(bookUtils.getISBN())
                    .title(FAKER.book().title())
                    .publisher(FAKER.book().publisher())
                    .price(bookUtils.getPrice())
                    .build();

        author.addBook(book);
        authorRepository.save(author);
        bookRepository.save(book);

        }
    }
}


