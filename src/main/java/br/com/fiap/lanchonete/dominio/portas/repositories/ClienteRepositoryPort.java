package br.com.fiap.lanchonete.dominio.portas.repositories;

import java.util.List;

import br.com.fiap.lanchonete.dominio.Cliente;

public interface ClienteRepositoryPort {

	List<Cliente> buscarTodos();

	Cliente incluir(Cliente cliente);

	Cliente alterar(Cliente cliente);

	void excluir(Long id);

	Cliente buscarPorCPF(String cpf);

}
