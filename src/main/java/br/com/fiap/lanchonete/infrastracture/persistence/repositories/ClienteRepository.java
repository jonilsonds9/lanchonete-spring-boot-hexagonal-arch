package br.com.fiap.lanchonete.infrastracture.persistence.repositories;

import br.com.fiap.lanchonete.domain.Cliente;
import br.com.fiap.lanchonete.domain.ports.repositories.ClienteRepositoryPort;
import br.com.fiap.lanchonete.infrastracture.persistence.entidades.ClienteEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClienteRepository implements ClienteRepositoryPort {

	private final SpringClientesRepository springClientesRepository;

	public ClienteRepository(SpringClientesRepository springClientesRepository) {
		this.springClientesRepository = springClientesRepository;
	}

	@Override
	public List<Cliente> buscarTodos() {
		List<ClienteEntity> clienteEntities = this.springClientesRepository.findAll();
		return clienteEntities.stream().map(ClienteEntity::toCliente).toList();
	}

	@Override
	public Cliente salvar(Cliente cliente) {
		ClienteEntity clienteEntity = this.springClientesRepository.save(new ClienteEntity(cliente));
		return clienteEntity.toCliente();
	}

	@Override
	public Optional<Cliente> buscarPorCpf(String cpf) {
		Optional<ClienteEntity> optionalClienteEntity = this.springClientesRepository.findByCpf(cpf);
		return optionalClienteEntity.map(ClienteEntity::toCliente);
	}
}
