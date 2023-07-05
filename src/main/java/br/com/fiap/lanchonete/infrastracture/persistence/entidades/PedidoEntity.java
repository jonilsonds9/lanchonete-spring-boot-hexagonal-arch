package br.com.fiap.lanchonete.infrastracture.persistence.entidades;

import br.com.fiap.lanchonete.domain.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "pedidos")
public class PedidoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	private String codigoPedido;

	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente", nullable = true)
	private ClienteEntity cliente;

	@OneToMany
	@JoinColumn(name = "pedido_id")
	private List<ItemPedidoEntity> itensPedido = new ArrayList<>();

	private BigDecimal valorTotal;

	@Enumerated(EnumType.STRING)
	private Situacao situacao;

	@Deprecated
	public PedidoEntity() {
	}

	public PedidoEntity(Long id, String codigoPedido, ClienteEntity cliente, List<ItemPedidoEntity> itensPedido,
						BigDecimal valorTotal, Situacao situacao) {
		this.id = id;
		this.codigoPedido = codigoPedido;
		this.cliente = cliente;
		this.itensPedido = itensPedido;
		this.valorTotal = valorTotal;
		this.situacao = situacao;
	}

	public PedidoEntity(Pedido pedido) {
		this(pedido.getId(), pedido.getCodigoPedido(), new ClienteEntity(pedido.getCliente()),
				pedido.getItensPedido().stream().map(ItemPedidoEntity::new).toList(),
				pedido.getValorTotal(), pedido.getSituacao());
	}

	public Pedido toPedido() {
		List<ItemPedido> itemPedidos = this.itensPedido.stream().map(ItemPedidoEntity::toItemPedido).toList();

		return new Pedido(this.id, this.codigoPedido, this.cliente.toCliente(), itemPedidos, this.valorTotal,
				this.situacao);
	}
}
