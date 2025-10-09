package hu.unideb.repository;

import hu.unideb.model.Student;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Repository
public class StudentRepositoryImpl
        implements StudentRepository {

    private final Map<String, Student> students;

    public StudentRepositoryImpl() {
        this.students = new HashMap<>();
    }

    @Override
    public List<Student> findAll() {
        return students.values()
                .stream()
                .sorted(
                        Comparator.comparing(Student::getNeptun)
                )
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Student> findByNeptun(
            @NonNull final String neptun) {

        return Optional.ofNullable(
                students.get(neptun)
        );
    }

    @Override
    public Student createOne(
            @NonNull final Student student) {

        student.setCreated(OffsetDateTime.now());
        student.setUpdated(OffsetDateTime.now());
        students.put(student.getNeptun(), student);
        return student;
    }

    @Override
    public Student updateOne(
            @NonNull final Student student) {

        final var original = students.get(student.getNeptun());
        original.setName(student.getName());
        original.setProgram(student.getProgram());
        original.setUpdated(OffsetDateTime.now());
        return original;
    }

    @Override
    public void deleteByNeptun(
            @NonNull final String neptun) {

        students.remove(neptun);
    }
}
