package br.com.fiap.lanchonete.domain.ports.services;

import br.com.fiap.lanchonete.domain.Categoria;
import br.com.fiap.lanchonete.domain.Produto;
import br.com.fiap.lanchonete.domain.ports.repositories.ProdutoRepositoryPort;
import br.com.fiap.lanchonete.domain.ports.services.ProdutoServicePort;

import java.util.List;
import java.util.Optional;

public class ProdutoServiceImp implements ProdutoServicePort {

    private final ProdutoRepositoryPort produtoRepositoryPort;

    public ProdutoServiceImp(ProdutoRepositoryPort produtoRepositoryPort) {
        this.produtoRepositoryPort = produtoRepositoryPort;
    }

	@Override
	public List<Produto> buscarTodos() {
		return this.produtoRepositoryPort.buscarTodos();
	}

	@Override
	public Optional<Produto> buscarPorId(Long id) {
		return this.produtoRepositoryPort.buscarPorId(id);
	}

	@Override
	public Produto cadastrar(Produto produto) {
		return this.produtoRepositoryPort.salvar(produto);
	}

	@Override
	public Produto alterar(Produto produto) {
		return this.produtoRepositoryPort.salvar(produto);
	}

	@Override
	public void excluir(Long id) {
		this.produtoRepositoryPort.excluir(id);
	}

	@Override
	public List<Produto> buscarPorCategoria(Categoria categoria) {
		return this.produtoRepositoryPort.buscarPorCategoria(categoria);
	}
}
