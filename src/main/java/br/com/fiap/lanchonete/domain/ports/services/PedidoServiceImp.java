package br.com.fiap.lanchonete.domain.ports.services;

import br.com.fiap.lanchonete.domain.Pedido;
import br.com.fiap.lanchonete.domain.ports.repositories.PedidoRepositoryPort;
import br.com.fiap.lanchonete.domain.ports.services.PedidoServicePort;

import java.util.List;
import java.util.Optional;

public class PedidoServiceImp implements PedidoServicePort {


    private final PedidoRepositoryPort pedidoRepositoryPort;

    public PedidoServiceImp(PedidoRepositoryPort pedidoRepositoryPort) {
        this.pedidoRepositoryPort = pedidoRepositoryPort;
    }

	@Override
	public List<Pedido> buscarTodos() {
        return this.pedidoRepositoryPort.buscarTodos();
	}

    @Override
    public Optional<Pedido> buscarPorId(Long id) {
        return this.pedidoRepositoryPort.buscarPorId(id);
    }

    @Override
    public Optional<Pedido> buscarPorCodigoPedido(String codigo) {
        return this.pedidoRepositoryPort.buscarPorCodigoPedido(codigo);
    }

    @Override
    public Pedido novo(Pedido pedido) {
        Long aLong = this.pedidoRepositoryPort.ultimoPedido();
        return this.pedidoRepositoryPort.salvar(pedido);
    }
}
