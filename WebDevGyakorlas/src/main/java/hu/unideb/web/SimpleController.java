package hu.unideb.web;

import hu.unideb.model.Book;
import hu.unideb.repository.BookRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SimpleController {

    BookRepository bookRepository;

    @RequestMapping("/api/books")
    public List<Book> getAll(){
        return bookRepository.getAllBooks();
    }

}
