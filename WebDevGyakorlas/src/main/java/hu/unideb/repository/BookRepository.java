package hu.unideb.repository;

import hu.unideb.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, String> {


    List<Book> findAll();

    @Query("SELECT b.genre, COUNT(b) FROM BOOKS  b GROUP BY b.genre")
    List<Object[]> countBooksByGenre();


    @Query("SELECT b.publisher, COUNT(b) FROM BOOKS  b GROUP BY b.publisher")
    List<Object[]> countBooksByPublisher();

    @Query("SELECT COUNT(b) FROM BOOKS b")
    Long countAllBooks();


}
