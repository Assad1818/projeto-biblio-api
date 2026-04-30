package com.guilhermeAssad.projeto_biblio_api.exception.user;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id){
        super("Usuário já cadastrado!");
    }
}
