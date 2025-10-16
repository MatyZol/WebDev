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
@Order(2)
@Slf4j
public class EnrollmentRunner
    implements CommandLineRunner {

    private final EnrollmentRepository enrollmentRepository;
    private final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        final var student = studentRepository.findAll().getFirst();
        final var subject = subjectRepository.findAll().getFirst();
        var enrollment = Enrollment.builder()
                .subject(subject)
                .student(student)
                .created(OffsetDateTime.now())
                .updated(OffsetDateTime.now())
                .build();
        enrollment = enrollmentRepository.save(enrollment);
        log.info(enrollment.toString());
    }
}
