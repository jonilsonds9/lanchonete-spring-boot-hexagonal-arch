package br.com.fiap.lanchonete.dominio.portas.repositories;

import java.util.List;
import java.util.Optional;

import br.com.fiap.lanchonete.dominio.Categoria;

public interface CategoriaRepositoryPort {

	List<Categoria> buscarTodos();

	Optional<Categoria> buscarPorId(Long id);

	Categoria adicionar(Categoria categoria);

	Categoria alterar(Categoria categoria);

	void excluir(Long id);

}
