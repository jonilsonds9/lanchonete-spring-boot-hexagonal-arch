package br.com.fiap.lanchonete.core.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.fiap.lanchonete.application.apis.rest.dtos.ProdutosDto;
import br.com.fiap.lanchonete.infrastracture.databases.postgres.entidades.CategoriaEntity;
import br.com.fiap.lanchonete.infrastracture.databases.postgres.entidades.ProdutoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Produto {

	private Long id;
	private String nome;
	private String descricao;
	private BigDecimal preco;
	private LocalDateTime dataCadastro;
	private Boolean status;
	private CategoriaEntity categorias;

	public Produto(ProdutoEntity produtos) {
		this.id = produtos.getId();
		this.nome = produtos.getNome();
		this.descricao = produtos.getDescricao();
		this.preco = produtos.getPreco();
		this.dataCadastro = produtos.getDataCadastro();
		this.status = produtos.getStatus();
		this.categorias = produtos.getCategorias();
	}

	public ProdutoEntity toEntity() {
		ProdutoEntity produto = new ProdutoEntity();
		produto.setId(this.getId());
		produto.setNome(this.nome);
		produto.setDescricao(this.descricao);
		produto.setDataCadastro(this.dataCadastro);
		produto.setPreco(this.preco);
		produto.setStatus(this.status);
		produto.setCategorias(this.categorias);
		return produto;
	}

	public ProdutosDto toProdutoDTO() {
		return new ProdutosDto(this.id, this.nome, this.descricao, this.dataCadastro, this.preco, this.status,
				this.categorias);
	}

	public Produto(ProdutosDto produtosDto) {
		this.id = produtosDto.getId();
		this.nome = produtosDto.getNome();
		this.descricao = produtosDto.getDescricao();
		this.preco = produtosDto.getPreco();
		this.dataCadastro = produtosDto.getDataCadastro();
		this.status = produtosDto.getStatus();
		this.categorias = produtosDto.getCategorias();
	}

	public static List<ProdutosDto> toDto(List<Produto> produtos) {
		List<ProdutosDto> produtosDtos = new ArrayList<>();

		for (var produto : produtos) {
			produtosDtos.add(toProdutoDto(produto));
		}

		return produtosDtos;
	}

	public static List<Produto> toProdutos(List<ProdutoEntity> produtoEntities) {
		return produtoEntities.stream().map(Produto::new).collect(Collectors.toList());
	}

	public Produto toProduto() {
		return new Produto(this.id, this.nome, this.descricao, this.preco, this.dataCadastro, this.status,
				this.categorias);
	}

	public static ProdutosDto toProdutoDto(Produto produto) {
		return new ProdutosDto(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getDataCadastro(),
				produto.getPreco(), produto.getStatus(), produto.getCategorias());
	}
}
