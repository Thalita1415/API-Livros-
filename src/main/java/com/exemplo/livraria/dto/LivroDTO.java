package com.exemplo.livraria.dto;

import lombok.Data;

// Anotação do Lombok que gera automaticamente os métodos:
// getters, setters, equals, hashCode e toString.
@Data
public class LivroDTO {

    // Identificador do livro (opcional em alguns casos de criação, obrigatório em atualizações).
    private Long id;

    // Título do livro.
    private String titulo;

    // Nome do autor do livro.
    private String autor;

    // Ano de publicação.
    private int ano;
}
