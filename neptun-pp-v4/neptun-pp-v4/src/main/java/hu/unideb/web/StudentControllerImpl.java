package hu.unideb.web;

import hu.unideb.model.Program;
import hu.unideb.model.Student;
import hu.unideb.repository.StudentRepository;
import hu.unideb.util.NeptunUtils;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@Slf4j
public class StudentControllerImpl
        implements StudentController {

    private final StudentRepository repository;

    @Override
    public List<Student> getAll() {
        return repository.findAll();
    }

    @Override
    public Student getOne(
            @NonNull final String neptun) {

        return repository.findById(neptun)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public void deleteByNeptun(
            @NonNull String neptun) {

        repository.deleteById(neptun);
    }

    @Override
    public Student createOne(
            @NonNull Student student) {

        student.setNeptun(NeptunUtils.getNeptun());
        return repository.save(student);
    }

    @Override
    public Student updateOne(
            @NonNull Student student) {

        return repository.save(student);
    }

    @Override
    public Student createOneWithNeptun(
            @NonNull Student student) {

        if (student.getNeptun() == null) {
            throw new IllegalArgumentException("Neptun is required");
        }
        return repository.save(student);
    }

    @Override
    public String download() {
        return repository.findAll()
                .stream()
                .map(s -> s.getNeptun() + ";" +
                        s.getName() + ";" + s.getProgram())
                .collect(Collectors.joining("\n"));
    }

    @Override
    public ResponseEntity<String> download2() {
        final var headers = new HttpHeaders();
        headers.set("Content-Type", "text/csv");
        headers.set("Content-disposition", "attachment; filename=students.csv");

        return ResponseEntity.ok()
                .headers(headers)
                .body(download());
    }

    @Override
    public List<Student> search(
            @NonNull Optional<String> neptun,
            @NonNull Optional<String> name,
            @NonNull Optional<Program> program) {

        log.info("{} {} {}",
                neptun, name, program);

        return repository.findAll()
                .stream()
                .filter(
                        student -> program
                                .map(p -> p == student.getProgram())
                                .orElse(true)
                )
                .filter(
                        student -> neptun
                                .map(s -> student.getNeptun().contains(s))
                                .orElse(true)
                )
                .filter(
                        student -> name
                                .map(s -> student.getName().contains(s))
                                .orElse(true)
                )
                .toList();
    }
}
