package br.com.fiap.lanchonete.application.apis.rest.request;

import br.com.fiap.lanchonete.domain.Pedido;

import java.util.List;

public record PedidoRequestDto(String clienteCpf, List<ItemPedidoRequestDto> itensPedido) {

    public boolean clienteInformouCpf() {
        return this.clienteCpf != null && this.clienteCpf.trim().equals("");
    }
}
