package com.exemplo.livraria.model;

import jakarta.persistence.*;
import lombok.Data;

// Anotação do Lombok que gera automaticamente getters, setters, equals, hashCode e toString.
@Data

// Indica que esta classe é uma entidade JPA, ou seja, será mapeada para uma tabela no banco.
@Entity
public class Livro {

    // Define o campo 'id' como a chave primária da tabela.
    @Id

    // Define que o valor do 'id' será gerado automaticamente pelo banco, com auto-incremento.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Campo para o título do livro.
    private String titulo;

    // Campo para o nome do autor do livro.
    private String autor;

    // Campo para o ano de publicação do livro.
    private int ano;
}

