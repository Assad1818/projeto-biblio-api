package com.guilhermeAssad.projeto_biblio_api.exception.user;

public class DuplicateUserException extends RuntimeException{
    public DuplicateUserException(String email){
        super("Usuário já cadastrado!");
    }
}
