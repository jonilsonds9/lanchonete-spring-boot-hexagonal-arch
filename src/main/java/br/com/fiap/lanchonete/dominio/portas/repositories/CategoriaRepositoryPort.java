package br.com.fiap.lanchonete.dominio.portas.repositories;

import java.util.List;
import java.util.Optional;

import br.com.fiap.lanchonete.dominio.Categoria;

public interface CategoriaRepositoryPort {

	public List<Categoria> buscarTodos();

	public Optional<Categoria> buscarPorId(Long id);

	public Categoria incluir(Categoria categoria);

	public Categoria alterar(Categoria categoria);

	public void excluir(Long id);

}
