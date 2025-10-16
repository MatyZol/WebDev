package hu.unideb.runner;

import com.github.javafaker.Faker;
import hu.unideb.model.Program;
import hu.unideb.model.Student;
import hu.unideb.repository.StudentRepository;
import hu.unideb.util.NeptunUtils;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
@AllArgsConstructor
@Order(1)
public class StudentRunner
        implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentRunner.class);
    private static final Faker FAKER = new Faker();

    private final StudentRepository repository;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 100; i++) {
            final var name = FAKER.name();
            final var student = repository
                    .save(
                            Student.builder()
                                    .neptun(NeptunUtils.getNeptun())
                                    .name(name.firstName() + " " + name.lastName())
                                    .program(Program.random())
                                    .created(OffsetDateTime.now())
                                    .updated(OffsetDateTime.now())
                                    .build()
                    );
            LOGGER.info("Student inserted: {}", student);
        }
        LOGGER.info("All students inserted, count: {}", repository.count());
    }
}
