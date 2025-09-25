package hu.unideb.web;

import hu.unideb.model.Student;
import hu.unideb.repository.StudentRepository;
import hu.unideb.repository.StudentRepositoryImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentControllerImpl
        implements StudentController {

    private final StudentRepository studentRepository;


    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student getOne(
            @NonNull final String neptun) {
     return studentRepository.findByNeptun(neptun).orElseThrow(IllegalArgumentException::new);
//        return Student.builder()
//                .neptun(neptun)
//                .name("Teszt Elek")
//                .program(Student.Program.CS_BSC)
//                .created(OffsetDateTime.now().minusHours(1))
//                .updated(OffsetDateTime.now())
//                .build();
    }
}
