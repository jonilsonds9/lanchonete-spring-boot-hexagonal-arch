package br.com.fiap.lanchonete.dominio.portas.repositories;

import java.util.List;

import br.com.fiap.lanchonete.dominio.Produto;

public interface ProdutoRepositoryPort {

	public List<Produto> findAll();

	public Produto incluir(Produto produto);

	public Produto alterar(Produto produto);

	public void excluir(Long id);

	public List<Produto> buscarPorCategoria(String categoria);

}
