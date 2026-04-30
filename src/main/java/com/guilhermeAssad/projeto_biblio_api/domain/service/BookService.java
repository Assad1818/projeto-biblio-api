package com.guilhermeAssad.projeto_biblio_api.domain.service;

import com.guilhermeAssad.projeto_biblio_api.domain.model.Book;
import com.guilhermeAssad.projeto_biblio_api.domain.repository.BookRepository;
import com.guilhermeAssad.projeto_biblio_api.dto.request.BookRequest;
import com.guilhermeAssad.projeto_biblio_api.dto.response.BookResponse;
import com.guilhermeAssad.projeto_biblio_api.exception.book.BookNotFoundException;
import com.guilhermeAssad.projeto_biblio_api.exception.book.DuplicateBookException;
import com.guilhermeAssad.projeto_biblio_api.mapper.BookMapper;
import com.guilhermeAssad.projeto_biblio_api.utils.EAvailable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    private Book findBookOrThrow(Long id){
        return bookRepository.findById(id)
                .orElseThrow(()-> new BookNotFoundException(id));
    }

    private void validateDuplicateBook(BookRequest request){
        boolean exists = bookRepository.existsByNameContainingIgnoreCaseAndAuthorContainingIgnoreCase(
                request.getName(), request.getAuthor()
        );
        if (exists){
            throw new DuplicateBookException(request.getName(), request.getAuthor());
        }
    }

    public BookResponse create (BookRequest request){
        validateDuplicateBook(request);
        Book book = bookMapper .toEntity(request);

        return bookMapper.toResponse(bookRepository.save(book));
    }

    public void delete (Long id){
        Book book = findBookOrThrow(id);
        bookRepository.delete(book);
    }
    public BookResponse getById(Long id){
        Book book = findBookOrThrow(id);
        return bookMapper.toResponse(book);
    }

    public List<BookResponse> findAll(){
        return bookMapper.toBookResponseList(bookRepository.findAll());
    }

    public BookResponse update(Long id, BookRequest request){
        Book book = findBookOrThrow(id);
        book.updateFrom(bookMapper.toEntity(request));
        return bookMapper.toResponse(bookRepository.save(book));
    }

    public List<BookResponse> findByName(String name){
        return bookMapper.toBookResponseList(bookRepository.findByNameContainingIgnoreCase(name));
    }

    public List<BookResponse> findByGenre(String genre){
        return bookMapper.toBookResponseList(bookRepository.findByGenreContainingIgnoreCase(genre));
    }
    public List<BookResponse> findAvailable(EAvailable available){
        return bookMapper.toBookResponseList(bookRepository.findByAvailable(available));
    }
    public List<BookResponse> findByAuthor(String author){
        return bookMapper.toBookResponseList(bookRepository.findByAuthorIgnoreCase(author));
    }

}
