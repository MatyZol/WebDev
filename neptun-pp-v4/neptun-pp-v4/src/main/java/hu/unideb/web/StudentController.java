package hu.unideb.web;

import hu.unideb.model.Program;
import hu.unideb.model.Student;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public interface StudentController {
    @GetMapping("/api/student")
    List<Student> getAll();

    @GetMapping(
            path = "/api/student/download",
            produces = "text/csv"
    )
    String download();

    @GetMapping("/api/student/download-v2")
    ResponseEntity<String> download2();

    @GetMapping("/api/student/search")
    List<Student> search(
        @NonNull @RequestParam Optional<String> neptun,
        @NonNull @RequestParam Optional<String> name,
        @NonNull @RequestParam Optional<Program> program
    );

    @GetMapping("/api/student/{neptun}")
    Student getOne(
            @NonNull @PathVariable String neptun);

    @DeleteMapping("/api/student/{neptun}")
    void deleteByNeptun(
            @NonNull @PathVariable String neptun);

    @PostMapping("/api/student")
    Student createOne(
            @NonNull @RequestBody Student student);

    @PutMapping("/api/student")
    Student updateOne(
            @NonNull @RequestBody Student student);

    @PutMapping("/api/student/create")
    Student createOneWithNeptun(
            @NonNull @RequestBody Student student);

}
