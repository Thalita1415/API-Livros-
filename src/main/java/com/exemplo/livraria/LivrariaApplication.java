package com.exemplo.livraria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Anotação que marca esta classe como a classe principal do Spring Boot.
// Combina as anotações: @Configuration, @EnableAutoConfiguration e @ComponentScan.
@SpringBootApplication
public class LivrariaApplication {

    // Método principal que inicia a aplicação.
    public static void main(String[] args) {

        // Inicia a aplicação Spring Boot.
        // Cria o contexto da aplicação, configura os beans, configura o servidor embutido, etc.
        SpringApplication.run(LivrariaApplication.class, args);
    }
}
