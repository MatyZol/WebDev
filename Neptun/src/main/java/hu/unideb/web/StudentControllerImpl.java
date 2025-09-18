package hu.unideb.web;

import hu.unideb.model.Student;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
public class StudentControllerImpl  implements StudentController{
    @Override
    public List<Student> getAll() {
        return List.of();
    }

    @Override
    public Student getOne(String neptun) {
        return Student.builder()
                .neptun("x")
                .name("Teszt ELek")
                .program(Student.Program.CS_BSC)
                .created(OffsetDateTime.now().minusHours(1))
                .updated(OffsetDateTime.now())
                .build();
    }
}
