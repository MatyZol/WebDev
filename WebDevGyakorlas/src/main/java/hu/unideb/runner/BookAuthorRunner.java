package hu.unideb.runner;

import hu.unideb.model.BookAuthor;
import hu.unideb.repository.AuthorRepository;
import hu.unideb.repository.BookAuthorRepository;
import hu.unideb.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
//@AllArgsConstructor
//@Order(2)
//@Slf4j
public class BookAuthorRunner implements CommandLineRunner {

    private BookAuthorRepository bookAuthorRepository;
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        final var books =  bookRepository.findAll();
        final var authors =  authorRepository.findAll();
        for (int i = 0; i < books.size(); i++) {
            var bookAuthor = BookAuthor.builder().book(books.get(i)).author(authors.get(i)).build();
            bookAuthorRepository.save(bookAuthor);
        }
    }
}
