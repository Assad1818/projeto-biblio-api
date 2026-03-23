package com.guilhermeAssad.projeto_biblio_api.domain.repository;

import com.guilhermeAssad.projeto_biblio_api.domain.model.Book;
import com.guilhermeAssad.projeto_biblio_api.utils.EAvailable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository <Book, Long>{

    List<Book> findByNameContainingIgnoreCase (String name);

    List<Book> findByGenreContainingIgnoreCase (String genre);

    List<Book> findByAuthorIgnoreCase (String author);
    List<Book> findByAvailable (EAvailable available);
}
