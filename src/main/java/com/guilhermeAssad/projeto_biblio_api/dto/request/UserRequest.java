package com.guilhermeAssad.projeto_biblio_api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequest {

    @NotBlank(message = "O nome do usuário é obrigatório!!")
    @Size(min = 3, max = 100)
    private String name;

    @NotBlank(message = "O email é obrigatório!!")
    private String email;

    @NotBlank(message = "A senha é obrigatória!!")
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres!")
    private String password;
}
