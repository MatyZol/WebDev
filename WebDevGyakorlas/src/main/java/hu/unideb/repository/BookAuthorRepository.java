package hu.unideb.repository;

import hu.unideb.model.BookAuthor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface BookAuthorRepository extends CrudRepository<BookAuthor, UUID> {
    List<BookAuthor> findAll();
}
