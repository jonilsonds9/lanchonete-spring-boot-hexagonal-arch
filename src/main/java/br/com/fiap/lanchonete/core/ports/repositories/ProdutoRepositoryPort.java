package br.com.fiap.lanchonete.core.ports.repositories;

import java.util.List;

import br.com.fiap.lanchonete.core.domain.Produto;

public interface ProdutoRepositoryPort {

	List<Produto> findAll();

	Produto incluir(Produto produto);

	Produto alterar(Produto produto);

	void excluir(Long id);

	List<Produto> buscarPorCategoria(String categoria);

}
