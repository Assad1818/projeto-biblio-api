package com.guilhermeAssad.projeto_biblio_api.dto.response;

public record BookResponse(Long id,
                           String name,
                           String author,
                           String genre,
                           Integer releaseYear){
}
