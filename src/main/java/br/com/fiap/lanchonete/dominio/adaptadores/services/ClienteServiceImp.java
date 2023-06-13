package br.com.fiap.lanchonete.dominio.adaptadores.services;

import java.util.List;
import java.util.stream.Collectors;

import br.com.fiap.lanchonete.dominio.Cliente;
import br.com.fiap.lanchonete.dominio.dtos.ClientesDto;
import br.com.fiap.lanchonete.dominio.portas.interfaces.ClienteServicePort;
import br.com.fiap.lanchonete.dominio.portas.repositories.ClienteRepositoryPort;

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
