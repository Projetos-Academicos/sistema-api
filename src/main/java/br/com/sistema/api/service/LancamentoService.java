package br.com.sistema.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistema.api.model.Lancamento;
import br.com.sistema.api.repository.LancamentoRepository;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	
	public Lancamento consultarLancamentoPorId(Long id) {
		return this.lancamentoRepository.findOne(id);
	}
	
	public List<Lancamento> listarLancamentos(){
		return this.lancamentoRepository.findAll();
	}
}
