package com.exemplo.livraria.controller;

import com.exemplo.livraria.dto.LivroDTO;
import com.exemplo.livraria.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Anotação que define esta classe como um controlador REST.
// Com isso, os métodos retornarão objetos JSON diretamente.
@RestController

// Define o caminho base para todas as rotas deste controlador.
// Ou seja, todas as rotas terão o prefixo /livros.
@RequestMapping("/livros")
public class LivroController {

    // Injeta automaticamente uma instância de LivroService.
    // Isso permite que os métodos do serviço sejam utilizados aqui.
    @Autowired
    private LivroService livroService;

    // Mapeia requisições HTTP GET para /livros
    // Retorna uma lista de livros no formato DTO (Data Transfer Object).
    @GetMapping
    public List<LivroDTO> listar() {
        return livroService.listar();
    }

    // Mapeia requisições HTTP GET para /livros/{id}
    // Busca um livro específico pelo ID informado na URL.
    @GetMapping("/{id}")
    public Optional<LivroDTO> buscar(@PathVariable Long id) {
        return livroService.buscar(id);
    }

    // Mapeia requisições HTTP POST para /livros
    // Recebe um objeto LivroDTO no corpo da requisição e o salva.
    @PostMapping
    public LivroDTO salvar(@RequestBody LivroDTO livroDTO) {
        return livroService.salvar(livroDTO);
    }

    // Mapeia requisições HTTP PUT para /livros/{id}
    // Atualiza os dados de um livro existente, identificado pelo ID.
    @PutMapping("/{id}")
    public LivroDTO atualizar(@PathVariable Long id, @RequestBody LivroDTO livroDTO) {
        return livroService.atualizar(id, livroDTO);
    }

    // Mapeia requisições HTTP DELETE para /livros/{id}
    // Remove o livro correspondente ao ID informado.
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        livroService.deletar(id);
    }
}
