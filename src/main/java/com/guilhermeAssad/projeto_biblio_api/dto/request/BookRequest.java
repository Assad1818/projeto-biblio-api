package com.guilhermeAssad.projeto_biblio_api.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookRequest {
    @NotBlank(message = "O nome do livro é obrigatório!!")
    @Size(max = 50)
    private String name;

    @NotBlank(message = "O nome do autor é obrigatório!!")
    @Size(max = 100)
    private String author;

    @NotBlank(message = "O genêro do livro é obrigatório!!")
    @Size(max = 50)
    private String genre;

    @Max(2026)
    private Integer releaseYear;
}
