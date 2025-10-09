package hu.unideb.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Entity(name = "STUDENTS")
public class Student {
    @Id
    @EqualsAndHashCode.Include
    private String neptun;
    private String name;
    @Enumerated(EnumType.STRING)
    private Program program;
    private OffsetDateTime created;
    private OffsetDateTime updated;

}
