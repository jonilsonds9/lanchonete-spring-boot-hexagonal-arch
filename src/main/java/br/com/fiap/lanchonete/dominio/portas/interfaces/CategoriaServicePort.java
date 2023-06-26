package br.com.fiap.lanchonete.dominio.portas.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.fiap.lanchonete.dominio.dtos.CategoriaDto;
import br.com.fiap.lanchonete.dominio.dtos.categorias.CategoriaResponseDto;

public interface CategoriaServicePort {

	public List<CategoriaResponseDto> buscarTodos();

	public Optional<CategoriaResponseDto> buscarPorId(Long id);

	public CategoriaDto incluir(CategoriaDto categoriaDto);

	public CategoriaDto alterar(CategoriaDto categoriaDto);

	public void excluir(Long id);

}
