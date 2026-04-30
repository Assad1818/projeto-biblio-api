package com.guilhermeAssad.projeto_biblio_api.exception.rent;

public class RentNotFoundException extends RuntimeException{
    public RentNotFoundException(Long id){
        super("Aluguel não encontrado!");
    }
}
