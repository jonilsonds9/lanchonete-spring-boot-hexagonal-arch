package br.com.fiap.lanchonete.core.ports.repositories;

import java.util.List;

import br.com.fiap.lanchonete.core.domain.Cliente;

public interface ClienteRepositoryPort {

	List<Cliente> buscarTodos();

	Cliente incluir(Cliente cliente);

	Cliente alterar(Cliente cliente);

	void excluir(Long id);

	Cliente buscarPorCPF(String cpf);

}
