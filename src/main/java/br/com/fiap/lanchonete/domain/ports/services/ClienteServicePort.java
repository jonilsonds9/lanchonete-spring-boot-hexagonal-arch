package br.com.fiap.lanchonete.domain.ports.services;

import java.util.List;

import br.com.fiap.lanchonete.application.apis.rest.request.ClientesDto;

public interface ClienteServicePort {

	List<ClientesDto> buscarTodos();

	ClientesDto incluir(ClientesDto clientesDto);

	ClientesDto alterar(ClientesDto clientesDto);

	void excluir(Long id);

	ClientesDto BuscarPorCPF(String cpf);

}
