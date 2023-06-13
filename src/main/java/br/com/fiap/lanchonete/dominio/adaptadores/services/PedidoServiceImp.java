package br.com.fiap.lanchonete.dominio.adaptadores.services;

import java.util.List;
import java.util.stream.Collectors;

import br.com.fiap.lanchonete.dominio.Pedido;
import br.com.fiap.lanchonete.dominio.dtos.PedidoDto;
import br.com.fiap.lanchonete.dominio.portas.interfaces.PedidoServicePort;
import br.com.fiap.lanchonete.dominio.portas.repositories.PedidoRepositoryPort;

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
