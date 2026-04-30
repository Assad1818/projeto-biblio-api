package com.guilhermeAssad.projeto_biblio_api.domain.controller;

import com.guilhermeAssad.projeto_biblio_api.domain.service.BookService;
import com.guilhermeAssad.projeto_biblio_api.dto.request.BookRequest;
import com.guilhermeAssad.projeto_biblio_api.dto.response.BookResponse;
import com.guilhermeAssad.projeto_biblio_api.utils.EAvailable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponse create(@RequestBody BookRequest request){
        return bookService.create(request);
    }

    @GetMapping("/{id}")
    public BookResponse getById(@PathVariable Long id){
        return bookService.getById(id);
    }

    @GetMapping
    public List<BookResponse> findAll(){
        return bookService.findAll();
    }


    @PutMapping("/{id}")
    public BookResponse update(@PathVariable Long id, @RequestBody BookRequest request){
        return bookService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        bookService.delete(id);
    }


    @GetMapping("/search/name")
    public List<BookResponse> findByName(@RequestParam String name){
        return bookService.findByName(name);
    }

    @GetMapping("/search/genre")
    public List<BookResponse> findByGenre(@RequestParam String genre){
        return bookService.findByGenre(genre);
    }


    @GetMapping("/search/author")
    public List<BookResponse> findByAuthor(@RequestParam String author){
        return bookService.findByAuthor(author);
    }

    @GetMapping("/search/available")
    public List<BookResponse> findAvailable(@RequestParam EAvailable available){
        return bookService.findAvailable(available);
    }
}