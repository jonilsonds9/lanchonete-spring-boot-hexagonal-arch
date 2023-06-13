package br.com.fiap.lanchonete.infraestrutura.adaptadores.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.lanchonete.dominio.Categoria;
import br.com.fiap.lanchonete.dominio.portas.repositories.CategoriaRepositoryPort;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.CategoriaEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CategoriasRepository implements CategoriaRepositoryPort {
	
	@Autowired
	private SpringCategoriasRepository springCategoriasRepository;
	
	
	@Override
	public List<Categoria> buscarTodos() {
		List<CategoriaEntity> categoriaEntities = this.springCategoriasRepository.findAll();
		return Categoria.toCategorias(categoriaEntities); 
	}

	@Override
	public Categoria incluir(Categoria categoria) {
		CategoriaEntity entity = new CategoriaEntity(categoria.getNome());
		return new Categoria(this.springCategoriasRepository.save(entity));
	}

	@Override
	public Categoria alterar(Categoria categoria) {		
		CategoriaEntity entity = new CategoriaEntity(categoria.getId(), categoria.getNome());
		return new Categoria(this.springCategoriasRepository.save(entity));
	}

	@Override
	public void excluir(Long id) {
		CategoriaEntity entity = this.springCategoriasRepository.findById(id).get();
		this.springCategoriasRepository.delete(entity);			
	}

	@Override
	public Categoria buscarPorId(Long id) {
		CategoriaEntity entity = this.springCategoriasRepository.findById(id).get();
		return new Categoria(entity.getId(), entity.getNome());
	}
}
