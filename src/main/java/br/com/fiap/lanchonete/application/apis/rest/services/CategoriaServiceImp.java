package br.com.fiap.lanchonete.application.apis.rest.services;

import br.com.fiap.lanchonete.domain.Categoria;
import br.com.fiap.lanchonete.application.apis.rest.request.CategoriaRequestDto;
import br.com.fiap.lanchonete.application.apis.rest.response.CategoriaResponseDto;
import br.com.fiap.lanchonete.domain.ports.services.CategoriaServicePort;
import br.com.fiap.lanchonete.domain.ports.repositories.CategoriaRepositoryPort;
import br.com.fiap.lanchonete.infrastracture.exceptions.NotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CategoriaServiceImp implements CategoriaServicePort {


    private final CategoriaRepositoryPort categoriaRepositoryPort;

    public CategoriaServiceImp(CategoriaRepositoryPort categoriaRepositoryPort) {
        this.categoriaRepositoryPort = categoriaRepositoryPort;
    }

	@Override
	public List<CategoriaResponseDto> buscarTodos() {
        List<Categoria> categorias = this.categoriaRepositoryPort.buscarTodos();
//		return categorias.stream().map(Categoria::toCategoriaResponseDto).collect(Collectors.toList());
		return null;
	}

	@Override
	public Optional<CategoriaResponseDto> buscarPorId(Long id) {
		Optional<Categoria> optionalCategoria = this.categoriaRepositoryPort.buscarPorId(id);
//		return optionalCategoria.map(CategoriaResponseDto::new);
		return Optional.empty();
	}

	@Override
	public CategoriaResponseDto adicionar(CategoriaRequestDto categoriaRequestDto) {
//		Categoria categoria = new Categoria(categoriaRequestDto);
//		Categoria novaCategoria = this.categoriaRepositoryPort.adicionar(categoria);
//		return novaCategoria.toCategoriaResponseDto();
		return null;
	}

	@Override
	public CategoriaResponseDto alterar(Long id, CategoriaRequestDto categoriaRequestDto) {
//		Categoria categoria = this.categoriaRepositoryPort.buscarPorId(id).orElseThrow(NotFoundException::new);
//		categoria.atualizar(categoriaRequestDto);
//		Categoria categoriaAlterada = this.categoriaRepositoryPort.alterar(categoria);
//		return categoriaAlterada.toCategoriaResponseDto();
		return null;
	}

	@Override
	public void excluir(Long id) {
		this.categoriaRepositoryPort.excluir(id);			
	}
}
