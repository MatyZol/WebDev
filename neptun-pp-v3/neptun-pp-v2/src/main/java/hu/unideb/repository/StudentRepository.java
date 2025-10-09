package hu.unideb.repository;

import hu.unideb.model.Student;
import lombok.NonNull;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, String> {
    List<Student> findAll();


}
