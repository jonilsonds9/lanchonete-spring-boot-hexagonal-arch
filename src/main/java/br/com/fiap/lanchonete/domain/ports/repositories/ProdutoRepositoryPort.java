package br.com.fiap.lanchonete.domain.ports.repositories;

import java.util.List;

import br.com.fiap.lanchonete.domain.Produto;

public interface ProdutoRepositoryPort {

	List<Produto> findAll();

	Produto incluir(Produto produto);

	Produto alterar(Produto produto);

	void excluir(Long id);

	List<Produto> buscarPorCategoria(String categoria);

}
