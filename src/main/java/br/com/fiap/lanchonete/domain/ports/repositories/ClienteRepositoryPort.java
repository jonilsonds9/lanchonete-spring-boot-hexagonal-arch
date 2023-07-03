package br.com.fiap.lanchonete.domain.ports.repositories;

import java.util.List;
import java.util.Optional;

import br.com.fiap.lanchonete.domain.Cliente;

public interface ClienteRepositoryPort {

	List<Cliente> buscarTodos();

	Cliente salvar(Cliente cliente);

	Optional<Cliente> buscarPorCpf(String cpf);
}
