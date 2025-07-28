package com.exemplo.livraria.service;

import com.exemplo.livraria.dto.LivroDTO;
import com.exemplo.livraria.model.Livro;
import com.exemplo.livraria.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// Anotação que indica que esta classe é um serviço gerenciado pelo Spring.
// Isso permite que ela seja injetada em outros componentes com @Autowired.
@Service
public class LivroService {

    // Injeta automaticamente o repositório que acessa o banco de dados da entidade Livro.
    @Autowired
    private LivroRepository livroRepository;

    // Método auxiliar que converte uma entidade Livro para um DTO.
    // Isso é usado para separar a camada de dados da camada de apresentação.
    private LivroDTO toDTO(Livro livro) {
        LivroDTO dto = new LivroDTO();
        dto.setId(livro.getId());
        dto.setTitulo(livro.getTitulo());
        dto.setAutor(livro.getAutor());
        dto.setAno(livro.getAno());
        return dto;
    }

    // Método auxiliar que converte um DTO em uma entidade Livro.
    // Útil quando recebemos dados da API e queremos salvar no banco.
    private Livro toEntity(LivroDTO dto) {
        Livro livro = new Livro();
        livro.setId(dto.getId());
        livro.setTitulo(dto.getTitulo());
        livro.setAutor(dto.getAutor());
        livro.setAno(dto.getAno());
        return livro;
    }

    // Retorna a lista de todos os livros no formato DTO.
    // Utiliza o método auxiliar toDTO para converter cada entidade.
    public List<LivroDTO> listar() {
        return livroRepository.findAll()
                .stream()
                .map(this::toDTO) // converte cada Livro para LivroDTO
                .collect(Collectors.toList());
    }

    // Busca um livro pelo ID e, se encontrado, retorna como DTO.
    // O uso de Optional evita erros de null.
    public Optional<LivroDTO> buscar(Long id) {
        return livroRepository.findById(id)
                .map(this::toDTO);
    }

    // Salva um novo livro, convertendo o DTO em entidade e depois retornando o DTO salvo.
    public LivroDTO salvar(LivroDTO dto) {
        Livro livro = toEntity(dto);
        return toDTO(livroRepository.save(livro));
    }

    // Atualiza os dados de um livro existente com base no ID.
    // O ID é fixado no DTO para garantir a atualização do registro correto.
    public LivroDTO atualizar(Long id, LivroDTO dto) {
        dto.setId(id);
        Livro livro = toEntity(dto);
        return toDTO(livroRepository.save(livro));
    }

    // Remove um livro do banco de dados com base no ID informado.
    public void deletar(Long id) {
        livroRepository.deleteById(id);
    }
}
