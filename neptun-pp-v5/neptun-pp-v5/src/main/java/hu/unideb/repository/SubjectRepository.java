package hu.unideb.repository;

import hu.unideb.model.Subject;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubjectRepository
        extends CrudRepository<Subject, String> {

    List<Subject> findAll();
}
