package br.com.fiap.lanchonete.application.apis.rest.response;

import br.com.fiap.lanchonete.domain.Cliente;

public record PedidoClienteResponseDto(Long id, String cpf, String nome) {

    public PedidoClienteResponseDto(Cliente cliente) {
        this(cliente.getId(), cliente.getCpf(), cliente.getNome());
    }
}
