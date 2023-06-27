package br.com.fiap.lanchonete.dominio.portas.interfaces;

import br.com.fiap.lanchonete.dominio.dtos.categorias.CategoriaRequestDto;
import br.com.fiap.lanchonete.dominio.dtos.categorias.CategoriaResponseDto;

import java.util.List;
import java.util.Optional;

public interface CategoriaServicePort {

	List<CategoriaResponseDto> buscarTodos();

	Optional<CategoriaResponseDto> buscarPorId(Long id);

	CategoriaResponseDto adicionar(CategoriaRequestDto categoriaRequestDto);

	CategoriaResponseDto alterar(Long id, CategoriaRequestDto categoriaRequestDto);

	void excluir(Long id);

}
