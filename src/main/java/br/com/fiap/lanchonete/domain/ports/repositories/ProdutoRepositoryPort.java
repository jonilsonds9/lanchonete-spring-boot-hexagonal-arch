package br.com.fiap.lanchonete.domain.ports.repositories;

import java.util.List;
import java.util.Optional;

import br.com.fiap.lanchonete.domain.Categoria;
import br.com.fiap.lanchonete.domain.Produto;

public interface ProdutoRepositoryPort {

	List<Produto> buscarTodos();

	Optional<Produto> buscarPorId(Long id);

	List<Produto> buscarPorCategoria(Categoria categoria);

	Produto salvar(Produto produto);

	void excluir(Long id);
}
