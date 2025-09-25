package hu.unideb.web;

import hu.unideb.model.Student;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface StudentController {
    @GetMapping("/api/student")
    List<Student> getAll();

    @GetMapping("/api/student/{neptun}")
    Student getOne(
            @NonNull @PathVariable String neptun);
}
