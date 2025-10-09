package hu.unideb.runner;

import hu.unideb.model.Enrollment;
import hu.unideb.repository.EnrollmentRepository;
import hu.unideb.repository.StudentRepository;
import hu.unideb.repository.SubjectRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;


@Component
@AllArgsConstructor
@Slf4j
@Order(2)
public class EnrollmentRunner implements CommandLineRunner {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository  subjectRepository;


    @Override
    public void run(String... args) throws Exception {
        final var student = studentRepository.findAll().get(0);
        final var subject = subjectRepository.findAll().get(0);
        var enrollment = Enrollment.builder()
                .subject(subject)
                .student(student)
                .created(OffsetDateTime.now())
                .updated(OffsetDateTime.now())
                .build();
        enrollment = enrollmentRepository.save(enrollment);
    }
}
