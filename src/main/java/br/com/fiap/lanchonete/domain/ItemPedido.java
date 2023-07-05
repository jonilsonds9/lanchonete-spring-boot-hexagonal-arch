package br.com.fiap.lanchonete.domain;

import java.math.BigDecimal;

public class ItemPedido {

    private final Long id;
    private final Produto produto;
    private final Integer quantidade;
    private final BigDecimal precoTotal;

    public ItemPedido(Long id, Produto produto, Integer quantidade, BigDecimal precoTotal) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoTotal = precoTotal;
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
        return precoTotal;
    }
}
