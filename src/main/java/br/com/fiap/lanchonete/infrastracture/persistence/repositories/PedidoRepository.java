package br.com.fiap.lanchonete.infrastracture.persistence.repositories;

import br.com.fiap.lanchonete.infrastracture.apis.rest.exceptions.NotFoundException;
import br.com.fiap.lanchonete.domain.Pedido;
import br.com.fiap.lanchonete.domain.ports.repositories.PedidoRepositoryPort;
import br.com.fiap.lanchonete.infrastracture.persistence.entidades.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class PedidoRepository implements PedidoRepositoryPort {

	private final SpringPedidosRepository springPedidosRepository;
	private final SpringClientesRepository springClientesRepository;

	public PedidoRepository(SpringPedidosRepository springPedidosRepository, SpringClientesRepository springClientesRepository) {
		this.springPedidosRepository = springPedidosRepository;
		this.springClientesRepository = springClientesRepository;
	}


	@Override
	public List<Pedido> buscarTodos() {
		List<PedidoEntity> pedidosEntities = this.springPedidosRepository.findAll();
		return pedidosEntities.stream().map(PedidoEntity::toPedido).toList();
	}

	@Override
	public Optional<Pedido> buscarPorId(Long id) {
		Optional<PedidoEntity> optionalPedidoEntity = this.springPedidosRepository.findById(id);
		return optionalPedidoEntity.map(PedidoEntity::toPedido);
	}

	@Override
	public Optional<Pedido> buscarPorCodigoPedido(String codigo) {
		Optional<PedidoEntity> optionalPedidoEntity = this.springPedidosRepository.findByCodigoPedido(codigo);
		return optionalPedidoEntity.map(PedidoEntity::toPedido);
	}

	@Override
	public Integer ultimoPedido() {
		return this.springPedidosRepository.countPedidoEntityByDataHoraCadastro(LocalDate.now());
	}

	@Override
	public Pedido salvar(Pedido pedido) {
		ClienteEntity clienteEntity = this.springClientesRepository.findById(pedido.getCliente().getId()).orElseThrow(NotFoundException::new);
		PedidoEntity pedidoEntity = new PedidoEntity(pedido, clienteEntity);

		PedidoEntity pedidoEntitySaved = this.springPedidosRepository.save(pedidoEntity);

		return pedidoEntitySaved.toPedido();
	}
}
