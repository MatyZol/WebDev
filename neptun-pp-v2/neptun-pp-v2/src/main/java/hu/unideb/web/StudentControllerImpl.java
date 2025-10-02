package hu.unideb.web;

import hu.unideb.model.Student;
import hu.unideb.repository.StudentRepository;
import hu.unideb.util.NeptunUtils;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
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
    public String download() {
        return repository.findAll().stream().map(
                student -> student.getNeptun()
                        +";"+student.getName()
                        +";"+student.getProgram())
                .collect(Collectors.joining("\n"));
    }

    @Override
    public ResponseEntity<String> download2() {
        final var headers = new HttpHeaders();
        headers.set("Content-Type", "text/csv");
        headers.set("Content-Disposition", "attachment; filename=students.csv");
        return ResponseEntity.ok().headers(headers).body(download());

    }

    @Override
    public List<Student> search(@NonNull Optional<String> neptun,
                                @NonNull Optional<String> name,
                                @NonNull Optional<Student.Program> program) {

        log.info("{} {} {}",neptun,name,program);
        return repository.findAll().stream()
                .filter(student -> program
                        .map(p -> p == student.getProgram())
                        .orElse(true)
                )
                .filter(student -> name
                        .map(n -> student.getName().contains(n))
                        .orElse(true)
                )
                .filter(student -> neptun
                        .map(n -> student.getNeptun().contains(n))
                        .orElse(true))
                .toList();
    }

    @Override
    public Student getOne(
            @NonNull final String neptun) {

        return repository.findByNeptun(neptun)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public void deleteByNeptun(@NonNull String neptun) {
        repository.deleteByNeptun(neptun);
    }

    @Override
    public Student createOne(@NonNull Student student) {
        student.setNeptun(NeptunUtils.getNeptun());
        return repository.createOne(student);
    }

    @Override
    public Student updateOne(@NonNull Student student) {
        return repository.updateOne(student);
    }

    @Override
    public Student createOneWithNeptun(@NonNull Student student) {
        return repository.createOne(student);
    }


}
