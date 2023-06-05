package br.com.fiap.lanchonete.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fiap.lanchonete.dtos.ProdutosDto;

@Service
public interface ProdutosService {

	public List<ProdutosDto> findAll();

	public ProdutosDto incluir(ProdutosDto produtosDtoRequest);

	public ProdutosDto alterar(ProdutosDto produtosDtoRequest);

	public void excluir(Long id);

	public List<ProdutosDto> findByCategoria(String categoria);

}
