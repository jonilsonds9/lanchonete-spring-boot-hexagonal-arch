package br.com.fiap.lanchonete.application.apis.rest.response;

import br.com.fiap.lanchonete.domain.Cliente;

import java.time.LocalDate;

public record ClienteResponseDto(Long id, String cpf, String nome, String email, String telefone, LocalDate dataCadastro) {

    public ClienteResponseDto(Cliente cliente) {
        this(cliente.getId(), cliente.getCpf(), cliente.getNome(), cliente.getEmail(),
                cliente.getTelefone(), cliente.getDataCadastro());
    }
}
