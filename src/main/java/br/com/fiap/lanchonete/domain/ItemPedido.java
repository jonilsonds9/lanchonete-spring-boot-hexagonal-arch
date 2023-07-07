package br.com.fiap.lanchonete.domain;

import java.math.BigDecimal;

public class ItemPedido {

    private Long id;
    private final Produto produto;
    private final Integer quantidade;
    private final BigDecimal preco;

    public ItemPedido(Long id, Produto produto, Integer quantidade) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.preco = produto.getPreco().multiply(BigDecimal.valueOf(quantidade));
    }

    public ItemPedido(Produto produto, Integer quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.preco = produto.getPreco().multiply(BigDecimal.valueOf(quantidade));
    }

    public Long getId() {
        return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public BigDecimal getPrecoTotal() {
        return preco;
    }
}
