package br.com.fiap.lanchonete.application.apis.rest.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.fiap.lanchonete.domain.ports.services.ProdutoServicePort;
import br.com.fiap.lanchonete.domain.Produto;
import br.com.fiap.lanchonete.application.apis.rest.request.ProdutosDto;
import br.com.fiap.lanchonete.domain.ports.repositories.ProdutoRepositoryPort;

public class ProdutoServiceImp implements ProdutoServicePort {


    private final ProdutoRepositoryPort produtoRepositoryPort;

    public ProdutoServiceImp(ProdutoRepositoryPort produtoRepositoryPort) {
        this.produtoRepositoryPort = produtoRepositoryPort;
    }

	@Override
	public List<ProdutosDto> findAll() {
        List<Produto> produtos = this.produtoRepositoryPort.findAll();
        return produtos.stream().map(Produto::toProdutoDTO).collect(Collectors.toList());
	}

	@Override
	public ProdutosDto incluir(ProdutosDto produtosDto) {
		produtosDto.setStatus(true);
		produtosDto.setDataCadastro(LocalDateTime.now());
		Produto produto = new Produto(produtosDto);
		return Produto.toProdutoDto(produtoRepositoryPort.incluir(produto));
	}

	@Override
	public ProdutosDto alterar(ProdutosDto produtosDto) {
		Produto produto = new Produto(produtosDto);
		return Produto.toProdutoDto(produtoRepositoryPort.alterar(produto));
	}

	@Override
	public void excluir(Long id) {
		produtoRepositoryPort.excluir(id);		
	}

	@Override
	public List<ProdutosDto> buscarPorCategoria(String categoria) {
		List<Produto> produtos = produtoRepositoryPort.buscarPorCategoria(categoria);	
		return Produto.toDto(produtos);
	}
}
