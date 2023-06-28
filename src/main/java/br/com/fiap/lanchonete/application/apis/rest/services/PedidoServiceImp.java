package br.com.fiap.lanchonete.application.apis.rest.services;

import java.util.List;
import java.util.stream.Collectors;

import br.com.fiap.lanchonete.domain.Pedido;
import br.com.fiap.lanchonete.application.apis.rest.request.PedidoDto;
import br.com.fiap.lanchonete.domain.ports.services.PedidoServicePort;
import br.com.fiap.lanchonete.domain.ports.repositories.PedidoRepositoryPort;

public class PedidoServiceImp implements PedidoServicePort {


    private final PedidoRepositoryPort pedidoRepositoryPort;

    public PedidoServiceImp(PedidoRepositoryPort pedidoRepositoryPort) {
        this.pedidoRepositoryPort = pedidoRepositoryPort;
    }

	@Override
	public List<PedidoDto> buscarTodos() {
        List<Pedido> pedidos = this.pedidoRepositoryPort.buscarTodos();
        return pedidos.stream().map(Pedido::toPedidoDto).collect(Collectors.toList());
	}
	
}
