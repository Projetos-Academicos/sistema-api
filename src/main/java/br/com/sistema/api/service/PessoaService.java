package br.com.sistema.api.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.sistema.api.model.Pessoa;
import br.com.sistema.api.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	public void salvarPessoa(Pessoa pessoa) {
		this.pessoaRepository.save(pessoa);
	}
	
	public Pessoa salvarAndRetornarPessoa(Pessoa pessoa) {
		Pessoa pessoaSalva = this.pessoaRepository.save(pessoa);
		return pessoaSalva;
	}
	
	public List<Pessoa> consultarPessoas(){
		return this.pessoaRepository.findAll();
	}
	
	public Pessoa consultarPorId(Long id) {
		Pessoa pessoa = this.pessoaRepository.findOne(id);
		if(pessoa == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return pessoa ;
	}
	
	public void deletarPessoa(Long id) {
		this.pessoaRepository.delete(id);
	}
	
	public void atualizarPropriedadeAtivo(Long id, Boolean ativo) {
		Pessoa pessoaBanco = this.buscarPessoaPorId(id);
		pessoaBanco.setAtivo(ativo);
		
		this.pessoaRepository.save(pessoaBanco);
	}
	
	public Pessoa atualizarPessoa(Long id, Pessoa pessoaOld) {
		Pessoa pessoaBanco = this.buscarPessoaPorId(id);
		
		BeanUtils.copyProperties(pessoaOld, pessoaBanco, "id");
		Pessoa pessoa = this.salvarAndRetornarPessoa(pessoaBanco);
		return pessoa;
	}

	private Pessoa buscarPessoaPorId(Long id) {
		Pessoa pessoaBanco = this.consultarPorId(id);
		if(pessoaBanco == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return pessoaBanco;
	}
}
