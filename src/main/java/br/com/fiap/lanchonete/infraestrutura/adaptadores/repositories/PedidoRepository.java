package br.com.fiap.lanchonete.infraestrutura.adaptadores.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.lanchonete.dominio.Categoria;
import br.com.fiap.lanchonete.dominio.Pedido;
import br.com.fiap.lanchonete.dominio.portas.repositories.PedidoRepositoryPort;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.CategoriaEntity;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.PedidoEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PedidoRepository implements PedidoRepositoryPort {

	@Autowired
	private SpringPedidosRepository springPedidosRepository;

	@Override
	public List<Pedido> buscarTodos() {
		List<PedidoEntity> pedidoEntities = this.springPedidosRepository.findAll();
		return Pedido.toPedidos(pedidoEntities); 
	}

	

}
