package com.guilhermeAssad.projeto_biblio_api.exception.book;

public class BookAlreadyReturnException extends RuntimeException{
    public BookAlreadyReturnException(String name){
        super("Livro já foi retornado!");
    }
}
