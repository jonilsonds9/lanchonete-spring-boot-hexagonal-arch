package br.com.fiap.lanchonete.dominio.portas.interfaces;

import br.com.fiap.lanchonete.dominio.dtos.categorias.CategoriaRequestDto;
import br.com.fiap.lanchonete.dominio.dtos.categorias.CategoriaResponseDto;

import java.util.List;
import java.util.Optional;

public interface CategoriaServicePort {

	public List<CategoriaResponseDto> buscarTodos();

	public Optional<CategoriaResponseDto> buscarPorId(Long id);

	public CategoriaResponseDto adicionar(CategoriaRequestDto categoriaRequestDto);

	public CategoriaResponseDto alterar(Long id, CategoriaRequestDto categoriaRequestDto);

	public void excluir(Long id);

}
