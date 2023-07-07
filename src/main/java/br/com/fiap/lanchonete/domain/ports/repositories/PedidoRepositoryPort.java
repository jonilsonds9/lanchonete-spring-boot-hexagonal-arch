package br.com.fiap.lanchonete.domain.ports.repositories;

import java.util.List;
import java.util.Optional;

import br.com.fiap.lanchonete.domain.Pedido;

public interface PedidoRepositoryPort {

	List<Pedido> buscarTodos();

	Optional<Pedido> buscarPorId(Long id);

	Optional<Pedido> buscarPorCodigoPedido(String codigo);

	Pedido salvar(Pedido pedido);
}
