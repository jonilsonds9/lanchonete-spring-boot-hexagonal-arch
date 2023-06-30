package br.com.fiap.lanchonete.infrastracture.persistence.entidades;

import br.com.fiap.lanchonete.domain.Categoria;
import br.com.fiap.lanchonete.domain.Produto;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "produtos")
@SQLDelete(sql = "UPDATE produtos SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class ProdutoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private BigDecimal preco;
	private LocalDateTime dataCadastro;
	@Enumerated(EnumType.STRING)
    private Categoria categoria;
	private final boolean deleted = Boolean.FALSE;

	@Deprecated
	public ProdutoEntity() {
	}

	public ProdutoEntity(Long id, String nome, String descricao, BigDecimal preco, LocalDateTime dataCadastro,
						 Categoria categoria) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.dataCadastro = dataCadastro;
		this.categoria = categoria;
	}

	public ProdutoEntity(Produto produto) {
		this(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getDataCadastro(),
				produto.getCategoria());
	}

	public Produto toProduto() {
		return new Produto(this.id, this.nome, this.descricao, this.preco, this.dataCadastro, this.categoria);
	}
}
