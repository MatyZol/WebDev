package hu.unideb.web;

import hu.unideb.model.Book;
import hu.unideb.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class BookControllerImpl implements BookController {

    private final BookRepository bookRepository;

    @Override
    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(@NonNull final String isbn) {
        return bookRepository.findById(isbn).orElseThrow(IllegalArgumentException::new);
    }

}
