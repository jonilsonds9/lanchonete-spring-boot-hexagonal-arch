package br.com.fiap.lanchonete.core.ports.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import br.com.fiap.lanchonete.core.domain.Cliente;
import br.com.fiap.lanchonete.core.ports.services.ClienteServicePort;
import br.com.fiap.lanchonete.core.ports.repositories.ClienteRepositoryPort;
import br.com.fiap.lanchonete.application.apis.rest.dtos.ClientesDto;

public class ClienteServiceImp implements ClienteServicePort {


    private final ClienteRepositoryPort clienteRepositoryPort;

    public ClienteServiceImp(ClienteRepositoryPort clienteRepositoryPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;
    }

	@Override
	public List<ClientesDto> buscarTodos() {
        List<Cliente> clientes = this.clienteRepositoryPort.buscarTodos();
        return clientes.stream().map(Cliente::toClienteDTO).collect(Collectors.toList());
	}

	@Override
	public ClientesDto incluir(ClientesDto clientesDto) {
		clientesDto.setAtivo(true);
		Cliente cliente = new Cliente(clientesDto);
		return Cliente.toClienteDto(this.clienteRepositoryPort.incluir(cliente));
	}

	@Override
	public ClientesDto alterar(ClientesDto clientesDto) {
		Cliente cliente = new Cliente(clientesDto);
		return Cliente.toClienteDto(this.clienteRepositoryPort.alterar(cliente));
	}

	@Override
	public void excluir(Long id) {
		this.clienteRepositoryPort.excluir(id);			
	}

	@Override
	public ClientesDto BuscarPorCPF(String cpf) {
		Cliente clientes = this.clienteRepositoryPort.buscarPorCPF(cpf);	
		return Cliente.toClienteDto(clientes);
	}

}
