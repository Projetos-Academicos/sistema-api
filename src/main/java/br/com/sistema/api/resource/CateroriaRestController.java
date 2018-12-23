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
import org.springframework.web.bind.annotation.RestController;

import br.com.sistema.api.event.RecursoCriadoEvent;
import br.com.sistema.api.model.Categoria;
import br.com.sistema.api.service.CategoriaService;

@RestController
public class CateroriaRestController {

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private ApplicationEventPublisher publisher;
	
	@RequestMapping(value = "/categorias", method = RequestMethod.GET)
	public List<Categoria> listar() {
		return this.categoriaService.listarCategorias();
	}
	
	/*@RequestMapping(value = "/categoria/salvar", method = RequestMethod.POST) //METODO SALVAR PADRÃO
	public void cadastrar(@RequestBody Categoria categoria) {
		this.categoriaService.salvarCategoria(categoria);
	}*/

	/*@RequestMapping(value = "/categoria/cadastro", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED) // RETORNAR O STATUS (COMO FOI UM POST PARA CADASTRAR UM DADO, O CORRETO É O 201 CREATED, NÃO O 200 OK)
	public void cadastrar(@RequestBody Categoria categoria, HttpServletResponse response) { // METODO SALVAR INFORMANDO O LOCATION COM A URI DE VISUALIZAÇÃO DO OBJETO SALVO
		Categoria categoriaSalva = this.categoriaService.salvarAndRetornarCategoriaSalva(categoria);
		
		 // CRIAR E RETORNAR UMA URI PARA CONSULTA DO OBJETO CRIADO. 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(categoriaSalva.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString()); // INFORMA NO HEADER O LOCATION DA URI PARA ACESSAR O OBJETO SALVO.
	}*/
	
	@RequestMapping(value = "/categoria/cadastro", method = RequestMethod.POST)
	public ResponseEntity<Categoria> cadastrar(@Valid @RequestBody Categoria categoria, HttpServletResponse response){
		
		Categoria categoriaSalva = this.categoriaService.salvarAndRetornarCategoriaSalva(categoria);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalva.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva); //RETORNA O OBJETO SALVO NO BANCO, JÁ COM O ID.  USANDO ISSO NÃO PRECISA DA ANOTAÇÃO: @ResponseStatus, NEM DO: response.setHeader()
	}
	
	@RequestMapping(value = "/categoria/cadastro/{id}", method = RequestMethod.GET)
	public Categoria visualizar(@PathVariable Long id) {
		return this.categoriaService.buscarPeloId(id);
	}
	@RequestMapping(value = "/categoria/cadastro/{id}", method = RequestMethod.DELETE)
	public void deletarCategoria(@PathVariable Long id) {
		this.categoriaService.deletarCategotia(id);
	}
}
