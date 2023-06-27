package br.com.fiap.lanchonete.dominio.portas.repositories;

import java.util.List;

import br.com.fiap.lanchonete.dominio.Pedido;

public interface PedidoRepositoryPort {

	List<Pedido> buscarTodos();

}
