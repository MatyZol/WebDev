package hu.unideb.runner;

import hu.unideb.model.Program;
import hu.unideb.model.Subject;
import hu.unideb.repository.SubjectRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

@Component
@AllArgsConstructor
@Slf4j
@Order(1)
public class SubjectRunner implements CommandLineRunner {

    private final SubjectRepository repository;

    @Override
    public void run(String... args) throws Exception {
        try(final var br = new BufferedReader( new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/subjects.tsv"))))) {
            br.lines().map(s -> s.split("\t"))
                    .map(tokens -> Subject.builder()
                            .code(tokens[0])
                            .name(tokens[1])
                            .credits(Integer.parseInt(tokens[2]))
                            .limit(Integer.parseInt(tokens[3]))
                            .program(Program.valueOf(tokens[4]))
                            .build())
                    .map(repository::save)
                    .map(Subject::toString)
                    .forEach(log::info);
        }
    }
}
