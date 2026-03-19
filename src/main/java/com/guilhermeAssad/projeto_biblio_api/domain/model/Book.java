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

    @Column(name = "BOOK_NAME", length = 255, nullable = false)
    private String bookName;

    @Column(name = "AUTHOR", length = 1000, nullable = false)
    private String author;

    @Column(name = "RELEASE_YEAR", length = 4)
    private String releaseYear;

    @Column(name = "BOOK_GENRE", length = 255, nullable = false)
    private String bookGenre;

    @Column (name = "AMOUNT", nullable = false)
    private int amount;

    @Column(name = "AVAILABLE")
    @Enumerated(EnumType.STRING)
    private EAvailable available;

    public void updateBook(Book book){
        if (book.getBookName() !=null)
            this.bookName = book.getBookName();
        if (book.getAuthor() != null)
            this.author = book.getAuthor();
        if (book.getBookGenre() != null)
            this.bookGenre = book.getBookGenre();
        if (book.getReleaseYear() != null)
            this.releaseYear = book.releaseYear;
    }

    public Book(){
        this.available = EAvailable.YES;
    }

}
