package br.com.fiap.lanchonete.application.apis.rest.response;

import br.com.fiap.lanchonete.domain.Pedido;

public record PedidoResponseDto(Long id) {

    public PedidoResponseDto(Pedido pedido) {
        this(pedido.getId());
    }
}
