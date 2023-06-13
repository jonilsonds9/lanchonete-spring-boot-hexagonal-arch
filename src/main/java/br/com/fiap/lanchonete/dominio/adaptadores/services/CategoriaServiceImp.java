package br.com.fiap.lanchonete.dominio.adaptadores.services;

import java.util.List;
import java.util.stream.Collectors;

import br.com.fiap.lanchonete.dominio.Categoria;
import br.com.fiap.lanchonete.dominio.dtos.CategoriaDto;
import br.com.fiap.lanchonete.dominio.portas.interfaces.CategoriaServicePort;
import br.com.fiap.lanchonete.dominio.portas.repositories.CategoriaRepositoryPort;

public class CategoriaServiceImp implements CategoriaServicePort {


    private final CategoriaRepositoryPort categoriaRepositoryPort;

    public CategoriaServiceImp(CategoriaRepositoryPort categoriaRepositoryPort) {
        this.categoriaRepositoryPort = categoriaRepositoryPort;
    }

	@Override
	public List<CategoriaDto> buscarTodos() {
        List<Categoria> categorias = this.categoriaRepositoryPort.buscarTodos();
        return categorias.stream().map(Categoria::toCategoriaDto).collect(Collectors.toList());
	}

	@Override
	public CategoriaDto incluir(CategoriaDto categoriaDto) {
		Categoria categoria = new Categoria(categoriaDto);
		return Categoria.toCategoriaDto(this.categoriaRepositoryPort.incluir(categoria));
	}

	@Override
	public CategoriaDto alterar(CategoriaDto categoriaDto) {
		Categoria categoria = new Categoria(categoriaDto);
		return Categoria.toCategoriaDto(this.categoriaRepositoryPort.alterar(categoria));
	}

	@Override
	public void excluir(Long id) {
		this.categoriaRepositoryPort.excluir(id);			
	}

	@Override
	public CategoriaDto buscarPorId(Long id) {
		Categoria categoria = this.categoriaRepositoryPort.buscarPorId(id);	
		return Categoria.toCategoriaDto(categoria);
	}

}
