package br.com.fiap.lanchonete.domain.ports.repositories;

import java.util.List;

import br.com.fiap.lanchonete.domain.Pedido;

public interface PedidoRepositoryPort {

	List<Pedido> buscarTodos();

}
