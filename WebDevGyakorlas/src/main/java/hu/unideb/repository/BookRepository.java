package hu.unideb.repository;

import hu.unideb.model.Book;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookRepository {

    public Map<String, Book> books;

    BookRepository(){
        books = new HashMap<>();
    }

    public List<Book> getAllBooks(){
        return books.values().stream().toList();
    }

}
