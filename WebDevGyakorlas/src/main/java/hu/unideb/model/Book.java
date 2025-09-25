package hu.unideb.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder

public class Book {

    private String ISBN;
    private String title;
    private String author;

}
