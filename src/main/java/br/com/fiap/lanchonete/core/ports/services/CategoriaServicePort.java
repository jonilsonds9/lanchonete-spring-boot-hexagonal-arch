package br.com.fiap.lanchonete.core.ports.services;

import br.com.fiap.lanchonete.application.apis.rest.request.CategoriaRequestDto;
import br.com.fiap.lanchonete.application.apis.rest.response.CategoriaResponseDto;

import java.util.List;
import java.util.Optional;

public interface CategoriaServicePort {

	List<CategoriaResponseDto> buscarTodos();

	Optional<CategoriaResponseDto> buscarPorId(Long id);

	CategoriaResponseDto adicionar(CategoriaRequestDto categoriaRequestDto);

	CategoriaResponseDto alterar(Long id, CategoriaRequestDto categoriaRequestDto);

	void excluir(Long id);

}
