package hu.unideb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OrderColumn;
import lombok.*;
import org.springframework.core.annotation.Order;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Entity(name = "BOOKS")

public class Book {
    @Id
    @EqualsAndHashCode.Include
    private String ISBN;
    private String title;
    private String author;

}
