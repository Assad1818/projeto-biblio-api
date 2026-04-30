package com.guilhermeAssad.projeto_biblio_api.exception.book;

public class DuplicateBookException extends RuntimeException{
    public DuplicateBookException(String name, String author){
        super ("Livro já cadastrado!");
    }
}
