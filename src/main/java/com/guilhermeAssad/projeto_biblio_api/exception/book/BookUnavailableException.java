package com.guilhermeAssad.projeto_biblio_api.exception.book;

public class BookUnavailableException extends RuntimeException{
    public BookUnavailableException(String name){
        super ("Livro não está disponível!");
    }
}
