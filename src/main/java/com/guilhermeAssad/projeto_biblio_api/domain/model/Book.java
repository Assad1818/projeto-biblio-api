package com.guilhermeAssad.projeto_biblio_api.domain.model;

import com.guilhermeAssad.projeto_biblio_api.utils.EAvailable;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "TABLE_BOOK")
@EqualsAndHashCode(of = "id")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", length = 255, nullable = false)
    private String name;

    @Column(name = "AUTHOR", length = 1000, nullable = false)
    private String author;

    @Column(name = "RELEASE_YEAR", length = 4)
    private Integer releaseYear;

    @Column(name = "GENRE", length = 255, nullable = false)
    private String genre;

    @Column (name = "AMOUNT", nullable = false)
    private int amount;

    @Column(name = "AVAILABLE")
    @Enumerated(EnumType.STRING)
    private EAvailable available;

    public void updateFrom(Book book){
        if (book.getName() !=null)
            this.name = book.getName();
        if (book.getAuthor() != null)
            this.author = book.getAuthor();
        if (book.getGenre() != null)
            this.genre = book.getGenre();
        if (book.getReleaseYear() != null)
            this.releaseYear = book.getReleaseYear();
        if (book.getAmount() != 0 && book.getAmount() >0)
            this.amount = book.getAmount();
    }

    public Book(){
        this.available = EAvailable.YES;
    }

}
