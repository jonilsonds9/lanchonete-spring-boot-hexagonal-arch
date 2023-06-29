package br.com.fiap.lanchonete.domain.ports.services;

import br.com.fiap.lanchonete.domain.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteServicePort {

	List<Cliente> buscarTodos();

	Cliente cadastrar(Cliente cliente);

	Optional<Cliente> buscarPorCpf(String cpf);
}
