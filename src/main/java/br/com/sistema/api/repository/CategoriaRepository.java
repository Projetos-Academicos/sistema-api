package br.com.sistema.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sistema.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
