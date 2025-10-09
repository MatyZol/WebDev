package hu.unideb.repository;

import hu.unideb.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, String> {


    List<Book> findAll();
}
