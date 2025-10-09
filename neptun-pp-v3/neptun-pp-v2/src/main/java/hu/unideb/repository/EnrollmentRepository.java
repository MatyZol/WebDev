package hu.unideb.repository;

import hu.unideb.model.Enrollment;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface EnrollmentRepository extends CrudRepository<Enrollment, UUID> {


}
