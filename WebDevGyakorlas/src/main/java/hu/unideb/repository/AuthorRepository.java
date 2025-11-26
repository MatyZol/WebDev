package hu.unideb.repository;

import hu.unideb.model.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Long> {

   List<Author> findAll();

    @Query("SELECT a.firstName, a.lastName, COUNT(b) FROM BOOKS b JOIN b.author a GROUP BY a.authorID, a.firstName, a.lastName")
    List<Object[]> countBooksByAuthor();

    @Query("SELECT COUNT(a) FROM AUTHORS a")
    Long countAllAuthors();
}
