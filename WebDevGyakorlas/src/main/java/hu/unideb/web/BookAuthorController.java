package hu.unideb.web;

import hu.unideb.model.BookAuthor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface BookAuthorController {


    @PostMapping("/api/bookAuthor")
    BookAuthor createBookAuthor(@NonNull @RequestBody BookAuthor bookAuthor);
}
