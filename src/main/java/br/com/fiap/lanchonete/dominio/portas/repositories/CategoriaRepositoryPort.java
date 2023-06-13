package br.com.fiap.lanchonete.dominio.portas.repositories;

import java.util.List;

import br.com.fiap.lanchonete.dominio.Categoria;

public interface CategoriaRepositoryPort {

	public List<Categoria> buscarTodos();

	public Categoria incluir(Categoria categoria);

	public Categoria alterar(Categoria categoria);

	public Categoria buscarPorId(Long id);

	public void excluir(Long id);

}
