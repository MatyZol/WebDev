package hu.unideb.runner;

import com.github.javafaker.Faker;
import hu.unideb.model.Author;
import hu.unideb.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.ZoneOffset;

@Component
@AllArgsConstructor
@Slf4j
public class AuthorRunner implements CommandLineRunner {


    private static final Faker FAKER = new Faker();

    private final AuthorRepository authorRepository;

    @Override
    public void run(String... args) throws Exception {
        for  (int i = 0; i < 100; i++) {
            final var author = authorRepository.save(Author.builder()
                    .authorID(i)
                    .firstName(FAKER.name().firstName())
                    .lastName(FAKER.name().lastName())
                    .dateOfBirth(FAKER.date().birthday().toInstant().atOffset(ZoneOffset.UTC))
                    .build()
            );
            log.info(author.toString());
        }
    }
}
