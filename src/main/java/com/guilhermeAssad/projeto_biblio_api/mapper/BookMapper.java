package com.guilhermeAssad.projeto_biblio_api.mapper;

import com.guilhermeAssad.projeto_biblio_api.domain.model.Book;
import com.guilhermeAssad.projeto_biblio_api.dto.request.BookRequest;
import com.guilhermeAssad.projeto_biblio_api.dto.response.BookResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {
    public Book toEntity(BookRequest request){
        Book book = new Book();
        book.setName(request.getName());
        book.setAuthor(request.getAuthor());
        book.setGenre(request.getGenre());
        book.setReleaseYear(request.getReleaseYear());
        return book;
    }

    public BookResponse toResponse(Book book){
        return new BookResponse(book.getId(), book.getName(), book.getAuthor(), book.getGenre(), book.getReleaseYear());
    }

    public List<BookResponse> toBookResponseList(List<Book> books){
        return books.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

}
