package br.com.fiap.lanchonete.infrastracture.apis.rest.response;

import br.com.fiap.lanchonete.domain.ItemPedido;
import br.com.fiap.lanchonete.domain.Produto;

import java.math.BigDecimal;

public record ItemPedidoResponseDto(String nome,
                                    BigDecimal precoUnitario,
                                    Integer quantidade,
                                    BigDecimal precoTotal) {

    public ItemPedidoResponseDto(ItemPedido itemPedido) {
        this(itemPedido.getProduto().getNome(), itemPedido.getProduto().getPreco(), itemPedido.getQuantidade(),
                itemPedido.getPrecoTotal());
    }
}
