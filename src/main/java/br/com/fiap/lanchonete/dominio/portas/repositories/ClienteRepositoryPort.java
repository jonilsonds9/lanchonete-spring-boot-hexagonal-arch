package br.com.fiap.lanchonete.dominio.portas.repositories;

import java.util.List;

import br.com.fiap.lanchonete.dominio.Cliente;

public interface ClienteRepositoryPort {

	public List<Cliente> buscarTodos();

	public Cliente incluir(Cliente cliente);

	public Cliente alterar(Cliente cliente);

	public void excluir(Long id);

	public Cliente buscarPorCPF(String cpf);

}
