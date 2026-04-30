package com.guilhermeAssad.projeto_biblio_api.exception.book;


public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException (Long id){
        super("Livro não encontrado!");
    }

}
