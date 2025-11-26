package hu.unideb.model;


import jakarta.persistence.*;

import lombok.*;


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
    private int pageNumber;
    private String genre;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;



}
