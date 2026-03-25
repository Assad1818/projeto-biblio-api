package com.guilhermeAssad.projeto_biblio_api.dto.response;

import com.guilhermeAssad.projeto_biblio_api.utils.EUserType;

public record UserResponse(Long id, String name, String email, EUserType userType) {
}
