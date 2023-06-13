package br.com.fiap.lanchonete.dominio.portas.interfaces;

import java.util.List;

import br.com.fiap.lanchonete.dominio.dtos.ClientesDto;

public interface ClienteServicePort {

	public List<ClientesDto> buscarTodos();

	public ClientesDto incluir(ClientesDto clientesDto);

	public ClientesDto alterar(ClientesDto clientesDto);

	public void excluir(Long id);

	public ClientesDto BuscarPorCPF(String cpf);

}
