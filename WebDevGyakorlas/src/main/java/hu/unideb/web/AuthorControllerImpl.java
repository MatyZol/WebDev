package hu.unideb.web;

import hu.unideb.model.Author;
import hu.unideb.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@AllArgsConstructor
public class AuthorControllerImpl implements AuthorController {

    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author getOne(@NonNull Long authorID) {
        return authorRepository.findById(authorID).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public void deleteById(@NonNull Long authorID) {
        authorRepository.deleteById(authorID);
    }

    @Override
    public Author createAuthor(@NonNull Author author) {

        return authorRepository.save(author);
    }

    @Override
    public Author updateAuthor(@NonNull Author author) {
        return authorRepository.save(author);
    }


}
