package hu.unideb.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "ENROLLMENTS")
public class Enrollment {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @ManyToOne
    Student student;
    @ManyToOne
    Subject subject;
    Integer grade;
    OffsetDateTime created;
    OffsetDateTime updated;
}
