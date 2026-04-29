package com.guilhermeAssad.projeto_biblio_api.dto.response;

import com.guilhermeAssad.projeto_biblio_api.utils.ERentStatus;

import java.time.LocalDateTime;

public record RentResponse(Long id,
                           String userName,
                           String bookName,
                           ERentStatus status,
                           LocalDateTime dateRent,
                           LocalDateTime dateReturn
                           ) {
}
