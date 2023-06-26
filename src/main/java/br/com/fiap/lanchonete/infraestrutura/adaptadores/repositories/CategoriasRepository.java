package br.com.fiap.lanchonete.infraestrutura.adaptadores.repositories;

import br.com.fiap.lanchonete.dominio.Categoria;
import br.com.fiap.lanchonete.dominio.portas.repositories.CategoriaRepositoryPort;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.CategoriaEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class CategoriasRepository implements CategoriaRepositoryPort {

	private final SpringCategoriasRepository springCategoriasRepository;

	public CategoriasRepository(SpringCategoriasRepository springCategoriasRepository) {
		this.springCategoriasRepository = springCategoriasRepository;
	}

	@Override
	public List<Categoria> buscarTodos() {
		List<CategoriaEntity> categoriaEntities = this.springCategoriasRepository.findAll();
		return categoriaEntities.stream().map(Categoria::new).toList();
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
