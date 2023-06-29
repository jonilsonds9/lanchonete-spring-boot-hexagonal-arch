package br.com.fiap.lanchonete.domain.ports.services;

import br.com.fiap.lanchonete.application.apis.rest.request.CategoriaRequest;
import br.com.fiap.lanchonete.application.apis.rest.response.CategoriaResponseDto;

import java.util.List;
import java.util.Optional;

public interface CategoriaServicePort {

	List<CategoriaResponseDto> buscarTodos();

	Optional<CategoriaResponseDto> buscarPorId(Long id);

	CategoriaResponseDto adicionar(CategoriaRequest categoriaRequest);

	CategoriaResponseDto alterar(Long id, CategoriaRequest categoriaRequest);

	void excluir(Long id);

}
