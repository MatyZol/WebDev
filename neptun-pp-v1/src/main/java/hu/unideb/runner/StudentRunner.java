package hu.unideb.runner;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import hu.unideb.model.Student;
import hu.unideb.repository.StudentRepository;
import hu.unideb.web.StudentControllerImpl;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@AllArgsConstructor
public class StudentRunner implements CommandLineRunner {

    private static final Random RANDOM = new Random();
    private static final Faker  FAKER = new Faker();

    private static final String LETTERS = "ABCDEFGHIJKLMNOP";
    private static final String DIGITS = "0123456789";

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentRunner.class);

    private final StudentRepository repository;




    public static String getNeptun(){
        return IntStream.range(0,6)
                .mapToObj(pos -> pos == 0 ? LETTERS.charAt(RANDOM.nextInt(LETTERS.length())) :
                    (LETTERS+DIGITS).charAt(RANDOM.nextInt((LETTERS+DIGITS).length()))
                ).map(String::valueOf).collect(Collectors.joining());
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World!");

        for (int i = 0; i < 100; i++) {
            Name name = FAKER.name();
            Student student = Student.builder().neptun(getNeptun()).name(name.firstName()+" "+name.lastName()).program(Student.Program.radom()).build();

            student = repository.crateOne(student);
            LOGGER.info(student.toString());
        }
        LOGGER.info("count: {}",repository.findAll().size());
    }
}
