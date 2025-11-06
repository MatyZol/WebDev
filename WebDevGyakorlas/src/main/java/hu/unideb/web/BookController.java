package hu.unideb.web;

import hu.unideb.model.Book;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface BookController {

    @GetMapping("/api/book")
    List<Book> getAll();

    @GetMapping("/api/book/{isbn}")
    Book getBook(@NonNull @PathVariable String isbn);

    @DeleteMapping("/api/book/{isbn}")
    void deleteBookByIsbn(@NonNull @PathVariable String isbn);


    @PostMapping("/api/book")
    Book createBook(@NonNull @RequestBody Book book);

    @PostMapping("/api/book/create")
    Book createBookWithISBN(@NonNull @RequestBody Book book);

    @PutMapping("/api/book")
    Book updateBook(@NonNull @RequestBody Book book);

}
