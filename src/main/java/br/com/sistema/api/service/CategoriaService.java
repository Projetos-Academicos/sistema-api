package br.com.sistema.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistema.api.model.Categoria;
import br.com.sistema.api.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> listarCategorias(){ // METODO QUE LISTA TODAS AS CATEGORIAS INSERIDAS NO BANCO.
		return categoriaRepository.findAll();
	}
	
	public void salvarCategoria(Categoria categoria) { // METODO VOID, APENAS SALVA A CATEGORIA.
		this.categoriaRepository.save(categoria);
	}
	
	public Categoria salvarAndRetornarCategoriaSalva(Categoria categoria) { // METODO COM RETORNO CATEGORIA, PARA RETORNAR A CATEGORIA DEPOIS QUE DE SALVA.
		 Categoria categoriaSalva  = this.categoriaRepository.save(categoria); 
		 return categoriaSalva;
	}
	
	public Categoria buscarPeloId(Long id) { // METODO QUE BUSCA A CATEGORIA ATRAVEZ DO ID INFORMADO, RETORNANDO O OBJETO DO BANCO.
		return this.categoriaRepository.findOne(id);
	}
	
	public void deletarCategotia(Long id) {
		this.categoriaRepository.delete(id);
	}
}
