package br.com.fiap.lanchonete.core.ports.services;

import java.util.List;

import br.com.fiap.lanchonete.application.apis.rest.dtos.ClientesDto;

public interface ClienteServicePort {

	List<ClientesDto> buscarTodos();

	ClientesDto incluir(ClientesDto clientesDto);

	ClientesDto alterar(ClientesDto clientesDto);

	void excluir(Long id);

	ClientesDto BuscarPorCPF(String cpf);

}
