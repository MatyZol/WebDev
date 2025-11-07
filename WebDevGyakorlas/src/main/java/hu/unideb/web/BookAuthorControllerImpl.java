package hu.unideb.web;

import hu.unideb.model.BookAuthor;
import hu.unideb.repository.AuthorRepository;
import hu.unideb.repository.BookAuthorRepository;
import hu.unideb.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
public class BookAuthorControllerImpl implements BookAuthorController {

    private BookAuthorRepository bookAuthorRepository;
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    @Override
    public BookAuthor createBookAuthor(@NonNull BookAuthor bookAuthor) {

        return bookAuthorRepository.save(bookAuthor);
    }
}
