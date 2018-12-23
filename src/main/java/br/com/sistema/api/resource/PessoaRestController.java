package br.com.sistema.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistema.api.event.RecursoCriadoEvent;
import br.com.sistema.api.model.Pessoa;
import br.com.sistema.api.service.PessoaService;

@RestController
public class PessoaRestController {

	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@RequestMapping(value = "/pessoa/cadastro", method = RequestMethod.POST)
//	@PostMapping
	public ResponseEntity<Pessoa> cadastrar(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response) {
		Pessoa pessoaSalva = this.pessoaService.salvarAndRetornarPessoa(pessoa);	
		publisher.publishEvent(new RecursoCriadoEvent(this, response, pessoaSalva.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
	}
	
	@RequestMapping(value = "/pessoa/cadastro/{id}", method = RequestMethod.GET)
//	@GetMapping("/{id}")
	public Pessoa consultarPessoa(@PathVariable Long id) {
		return this.pessoaService.consultarPorId(id);
	}
	
	@RequestMapping(value = "/pessoas", method = RequestMethod.GET)
//	@GetMapping
	public List<Pessoa> listarPessoas(){
		return this.pessoaService.consultarPessoas();
	}
	
	@RequestMapping(value = "/pessoa/cadastro/{id}", method = RequestMethod.DELETE)
//	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarPessoa(@PathVariable Long id) {
		this.pessoaService.deletarPessoa(id);
	}
	
	@RequestMapping(value = "/pessoa/cadastro/{id}", method = RequestMethod.PUT)
//	@PutMapping("/{codigo}")
	public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable Long id, @Valid @RequestBody Pessoa pessoa){
		Pessoa pessoaAtualizada = this.pessoaService.atualizarPessoa(id, pessoa);
		return ResponseEntity.ok(pessoaAtualizada);
	}
	
	@RequestMapping(value = "/pessoa/cadastro/{id}/ativo", method = RequestMethod.PUT)
//	@PutMapping("/{codigo}/ativo")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarPropriedadeAtivo(@PathVariable Long id, @RequestBody Boolean ativo) {
		this.pessoaService.atualizarPropriedadeAtivo(id, ativo);
	}
}
