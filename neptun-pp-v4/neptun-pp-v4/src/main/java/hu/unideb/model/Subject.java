package hu.unideb.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "SUBJECTS")
public class Subject {
    @Id
    @EqualsAndHashCode.Include
    private String code;
    private String name;
    private int credits;
    @Column(name = "student_limit")
    private int limit;
    @Enumerated(EnumType.STRING)
    private Program program;
    private OffsetDateTime created;
    private OffsetDateTime updated;
}
