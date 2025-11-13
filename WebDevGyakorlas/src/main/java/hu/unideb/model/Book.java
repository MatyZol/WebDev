package hu.unideb.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.persistence.criteria.Join;
import lombok.*;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.domain.Specification;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

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
    private String publisher;
    private int price;


    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "BOOKS_AUTHORS",
            joinColumns = @JoinColumn(name = "book_isbn"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    @Builder.Default
    @JsonManagedReference
    @ToString.Exclude
    private Set<Author> authors = new HashSet<>();

    public void addAuthor(Author author) {
        authors.add(author);
        author.getBooks().add(this);
    }

}
