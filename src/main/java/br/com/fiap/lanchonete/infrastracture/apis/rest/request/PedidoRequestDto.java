package br.com.fiap.lanchonete.infrastracture.apis.rest.request;

import java.util.List;

public record PedidoRequestDto(String clienteCpf, List<ItemPedidoRequestDto> itensPedido) {

    public boolean clienteInformouCpf() {
        return this.clienteCpf != null && !this.clienteCpf.trim().equals("");
    }
}
