package br.com.fiap.lanchonete.application.apis.rest.services;

import br.com.fiap.lanchonete.domain.Cliente;
import br.com.fiap.lanchonete.domain.ports.repositories.ClienteRepositoryPort;
import br.com.fiap.lanchonete.domain.ports.services.ClienteServicePort;

import java.util.List;
import java.util.Optional;

public class ClienteServiceImp implements ClienteServicePort {


    private final ClienteRepositoryPort clienteRepositoryPort;

    public ClienteServiceImp(ClienteRepositoryPort clienteRepositoryPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;
    }

	@Override
	public List<Cliente> buscarTodos() {
		return this.clienteRepositoryPort.buscarTodos();
	}

	@Override
	public Cliente cadastrar(Cliente cliente) {
		return this.clienteRepositoryPort.salvar(cliente);
	}

	@Override
	public Optional<Cliente> buscarPorCpf(String cpf) {
		return this.clienteRepositoryPort.buscarPorCpf(cpf);
	}
}
