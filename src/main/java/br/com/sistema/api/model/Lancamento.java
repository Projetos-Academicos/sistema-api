package br.com.sistema.api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.sistema.api.enums.TipoLancamentoEnum;

@Entity
@Table(name = "lancamento")
public class Lancamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotNull
	@Column(name = "descricao")
	private String descricao;
	
	@NotNull
	@Column(name = "data_vencimento")
	private LocalDate datVencimento;
	
	@NotNull
	@Column(name = "data_pagamento")
	private LocalDate datPagamento;
	
	@NotNull
	@Column(name = "valor")
	private BigDecimal valor;
	
	@NotNull
	@Column(name = "observacao")
	private String observacao;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_Lancamento")
	private TipoLancamentoEnum tipoLancamento;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;
	
	/*
	 * Construtores 
	 */
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getDatVencimento() {
		return datVencimento;
	}
	public void setDatVencimento(LocalDate datVencimento) {
		this.datVencimento = datVencimento;
	}
	public LocalDate getDatPagamento() {
		return datPagamento;
	}
	public void setDatPagamento(LocalDate datPagamento) {
		this.datPagamento = datPagamento;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public TipoLancamentoEnum getTipoLancamento() {
		return tipoLancamento;
	}
	public void setTipoLancamento(TipoLancamentoEnum tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
