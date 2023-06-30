package br.com.fiap.lanchonete.domain.ports.services;

import br.com.fiap.lanchonete.domain.Categoria;
import br.com.fiap.lanchonete.domain.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoServicePort {

	List<Produto> buscarTodos();

	Optional<Produto> buscarPorId(Long id);

	Produto cadastrar(Produto produto);

	Produto alterar(Produto produto);

	void excluir(Long id);

	List<Produto> buscarPorCategoria(Categoria categoria);
}
