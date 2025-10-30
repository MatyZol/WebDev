package hu.unideb.web;

import hu.unideb.model.Author;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface AuthorController {


    @GetMapping("/api/authors")
    List<Author> getAll();
}
