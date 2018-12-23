package br.com.sistema.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistema.api.model.Lancamento;
import br.com.sistema.api.service.LancamentoService;

@RestController
public class LancamentoRestController {

	@Autowired
	private LancamentoService lancamentoService;

	@RequestMapping(value = "/lancamento/cadastro/{id}", method = RequestMethod.GET)
	public ResponseEntity<Lancamento> consultarLancamento(@PathVariable Long id) {
		Lancamento lancamento = this.lancamentoService.consultarLancamentoPorId(id);
		return lancamento != null ? ResponseEntity.ok(lancamento) : ResponseEntity.notFound().build();
	}

	@RequestMapping(value = "/lancamentos", method = RequestMethod.GET)
	public List<Lancamento> listarLancamentos() {
		return this.lancamentoService.listarLancamentos();
	}
}
