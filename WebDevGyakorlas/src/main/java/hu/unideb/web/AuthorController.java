package hu.unideb.web;

import hu.unideb.model.Author;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface AuthorController {


    @GetMapping("/api/authors")
    List<Author> getAll();

    @GetMapping("/api/authors/{authorID}")
    Author getOne(@NonNull @PathVariable int authorID);

    @DeleteMapping("/api/authors/{authorID}")
    void deleteById(@NonNull @PathVariable int authorID);

    @PostMapping("/api/author")
    Author createAuthor(@NonNull @RequestBody Author author);

    @PutMapping("/api/author")
    Author updateAuthor(@NonNull @RequestBody Author author);


}
