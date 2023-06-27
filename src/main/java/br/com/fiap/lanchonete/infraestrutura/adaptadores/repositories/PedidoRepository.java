package br.com.fiap.lanchonete.infraestrutura.adaptadores.repositories;

import br.com.fiap.lanchonete.dominio.Pedido;
import br.com.fiap.lanchonete.dominio.portas.repositories.PedidoRepositoryPort;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.PedidoEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class PedidoRepository implements PedidoRepositoryPort {

	private final SpringPedidosRepository springPedidosRepository;

	public PedidoRepository(SpringPedidosRepository springPedidosRepository) {
		this.springPedidosRepository = springPedidosRepository;
	}

	@Override
	public List<Pedido> buscarTodos() {
		List<PedidoEntity> pedidoEntities = this.springPedidosRepository.findAll();
		return Pedido.toPedidos(pedidoEntities); 
	}

	

}
