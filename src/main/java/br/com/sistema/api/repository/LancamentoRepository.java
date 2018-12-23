package br.com.sistema.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sistema.api.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

}
