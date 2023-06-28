package br.com.fiap.lanchonete.core.ports.repositories;

import java.util.List;

import br.com.fiap.lanchonete.core.domain.Pedido;

public interface PedidoRepositoryPort {

	List<Pedido> buscarTodos();

}
