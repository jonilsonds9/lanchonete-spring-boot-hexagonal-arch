package br.com.fiap.lanchonete.dominio.portas.interfaces;

import java.util.List;

import br.com.fiap.lanchonete.dominio.dtos.ProdutosDto;

public interface ProdutoServicePort {

	public List<ProdutosDto> findAll();

	public ProdutosDto incluir(ProdutosDto produtosDto);

	public ProdutosDto alterar(ProdutosDto produtosDtoRequest);

	public void excluir(Long id);

	public List<ProdutosDto> buscarPorCategoria(String categoria);

}
