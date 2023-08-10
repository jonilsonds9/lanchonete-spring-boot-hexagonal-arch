package br.com.fiap.lanchonete.infrastracture.apis.rest.response;

import br.com.fiap.lanchonete.domain.*;

import java.math.BigDecimal;
import java.util.List;

public record PedidoResponseDto(Long id,
                                Integer codigoPedido,
                                PedidoClienteResponseDto cliente,
                                List<ItemPedidoResponseDto> itensPedido,
                                BigDecimal precoTotal,
                                Situacao situacao) {

    public PedidoResponseDto(Pedido pedido) {
        this(pedido.getId(), pedido.getCodigoPedido(),
                pedido.getCliente() != null ? new PedidoClienteResponseDto(pedido.getCliente()) : null,
                pedido.getItensPedido().stream().map(ItemPedidoResponseDto::new).toList(),
                pedido.getPrecoTotal(), pedido.getSituacao());
    }
}
