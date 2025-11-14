package hu.unideb.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


import java.time.OffsetDateTime;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Entity(name = "AUTHORS")
public class Author {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorID;
    private String firstName;
    private String lastName;
    private String dateOfBirth;


//    @ManyToMany(mappedBy = "authors", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JsonIgnore
//    @Builder.Default
//    @ToString.Exclude
//    private Set<Book> books = new HashSet<>();


    @OneToMany(mappedBy = "author",fetch = FetchType.LAZY)
    @Builder.Default
    @JsonIgnore
    private List<Book> books = new ArrayList<>();

    public void  addBook(Book book) {
        books.add(book);
        book.setAuthor(this);
    }

}
