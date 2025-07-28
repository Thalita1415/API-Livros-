package com.exemplo.livraria.repository;


import com.exemplo.livraria.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

// Interface que representa o repositório de acesso a dados para a entidade Livro.
// Ela estende JpaRepository, que já fornece todos os métodos básicos de CRUD e muito mais.
public interface LivroRepository extends JpaRepository<Livro, Long> {
}
