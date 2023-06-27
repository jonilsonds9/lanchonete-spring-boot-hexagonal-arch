package br.com.fiap.lanchonete.dominio.portas.interfaces;

import java.util.List;

import br.com.fiap.lanchonete.dominio.dtos.ClientesDto;

public interface ClienteServicePort {

	List<ClientesDto> buscarTodos();

	ClientesDto incluir(ClientesDto clientesDto);

	ClientesDto alterar(ClientesDto clientesDto);

	void excluir(Long id);

	ClientesDto BuscarPorCPF(String cpf);

}
