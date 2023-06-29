package br.com.fiap.lanchonete.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Produto {

	private final Long id;
	private final String nome;
	private final String descricao;
	private final BigDecimal preco;
	private final LocalDateTime dataCadastro;
	private final boolean disponivel;
	private final Categoria categoria;

	public Produto(Long id, String nome, String descricao, BigDecimal preco, LocalDateTime dataCadastro, boolean disponivel, Categoria categoria) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.dataCadastro = dataCadastro;
		this.disponivel = disponivel;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	@Override
	public String toString() {
		return "Produto{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", descricao='" + descricao + '\'' +
				", preco=" + preco +
				", dataCadastro=" + dataCadastro +
				", disponivel=" + disponivel +
				", categoria=" + categoria +
				'}';
	}

	public static class ProdutoBuilder {
		private Long id;
		private String nome;
		private String descricao;
		private BigDecimal preco;
		private LocalDateTime dataCadastro;
		private boolean disponivel;
		private Categoria categoria;

		public ProdutoBuilder() {
		}

		public ProdutoBuilder id(Long id) {
			this.id = id;
			return this;
		}

		public ProdutoBuilder descricao(String descricao) {
			this.descricao = descricao;
			return this;
		}

		public ProdutoBuilder preco(BigDecimal preco) {
			this.preco = preco;
			return this;
		}

		public ProdutoBuilder dataCadastro(LocalDateTime dataCadastro) {
			this.dataCadastro = dataCadastro;
			return this;
		}

		public ProdutoBuilder disponivel(boolean disponivel) {
			this.disponivel = disponivel;
			return this;
		}

		public ProdutoBuilder categoria(Categoria categoria) {
			this.categoria = categoria;
			return this;
		}

		public Produto build() {
			return new Produto(this.id, this.nome, this.descricao, this.preco, this.dataCadastro, this.disponivel,
					this.categoria);
		}
	}
}
