package hu.unideb.web;

import hu.unideb.model.Author;
import hu.unideb.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AuthorControllerImpl implements AuthorController {

    private AuthorRepository authorRepository;


    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }
}
