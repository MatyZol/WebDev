package hu.unideb.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Entity(name = "AUTHORS")
public class Author {
    @Id
    @EqualsAndHashCode.Include
    private int authorID;
    private String firstName;
    private String lastName;
    private OffsetDateTime dateOfBirth;

}
