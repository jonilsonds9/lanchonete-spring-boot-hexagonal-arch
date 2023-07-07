package br.com.fiap.lanchonete.infrastracture.persistence.entidades;

import br.com.fiap.lanchonete.domain.*;
import org.hibernate.annotations.Cascade;

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
    @JoinColumn(name = "cliente")
	private ClienteEntity cliente;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pedido_id")
	private List<ItemPedidoEntity> itensPedido = new ArrayList<>();

	private BigDecimal precoTotal;

	@Enumerated(EnumType.STRING)
	private Situacao situacao;

	@Deprecated
	public PedidoEntity() {
	}

	public PedidoEntity(Long id, String codigoPedido, Cliente cliente, List<ItemPedidoEntity> itensPedido,
						BigDecimal precoTotal, Situacao situacao) {
		this.id = id;
		this.codigoPedido = codigoPedido;
		this.cliente = cliente != null ? new ClienteEntity(cliente) : null;
		this.itensPedido = itensPedido;
		this.precoTotal = precoTotal;
		this.situacao = situacao;
	}

	public PedidoEntity(Pedido pedido) {
		this(pedido.getId(), pedido.getCodigoPedido(), pedido.getCliente(),
				pedido.getItensPedido().stream().map(ItemPedidoEntity::new).toList(),
				pedido.getPrecoTotal(), pedido.getSituacao());
	}

	public Pedido toPedido() {
		List<ItemPedido> itemPedidos = this.itensPedido.stream().map(ItemPedidoEntity::toItemPedido).toList();
		Cliente cliente = this.cliente != null ? this.cliente.toCliente() : null;
		return new Pedido(this.id, this.codigoPedido, cliente, itemPedidos, this.situacao);
	}
}
