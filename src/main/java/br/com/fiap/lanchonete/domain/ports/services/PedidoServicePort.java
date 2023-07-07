package br.com.fiap.lanchonete.domain.ports.services;

import br.com.fiap.lanchonete.domain.*;

import java.util.List;
import java.util.Optional;

public interface PedidoServicePort {

    List<Pedido> buscarTodos();

    Optional<Pedido> buscarPorId(Long id);

    Optional<Pedido> buscarPorCodigoPedido(String codigo);

    Pedido criar(Cliente cliente, List<ItemPedido> itemPedidos);
}
