package br.com.fiap.lanchonete.domain.ports.services;

import java.util.List;

import br.com.fiap.lanchonete.application.apis.rest.request.ProdutosDto;

public interface ProdutoServicePort {

	List<ProdutosDto> findAll();

	ProdutosDto incluir(ProdutosDto produtosDto);

	ProdutosDto alterar(ProdutosDto produtosDtoRequest);

	void excluir(Long id);

	List<ProdutosDto> buscarPorCategoria(String categoria);

}
