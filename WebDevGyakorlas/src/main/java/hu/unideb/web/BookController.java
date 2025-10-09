package hu.unideb.web;

import hu.unideb.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface BookController {

    @GetMapping("/api/books")
    List<Book> getAll();

    @GetMapping("api/books/{isbn}")
    Book getBook(@PathVariable String isbn);
}
