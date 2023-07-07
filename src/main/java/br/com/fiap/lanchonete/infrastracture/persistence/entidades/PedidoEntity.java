package br.com.fiap.lanchonete.infrastracture.persistence.entidades;

import br.com.fiap.lanchonete.domain.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente")
	private ClienteEntity cliente;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pedido_id")
	private List<ItemPedidoEntity> itensPedido = new ArrayList<>();

	private BigDecimal precoTotal;

	@Enumerated(EnumType.STRING)
	private Situacao situacao;

	@CreationTimestamp
	private LocalDateTime dataHoraCadastro;

	@Deprecated
	public PedidoEntity() {
	}

	public PedidoEntity(Pedido pedido) {
		this.codigoPedido = pedido.getCodigoPedido();
		this.cliente = pedido.getCliente() != null ? new ClienteEntity(pedido.getCliente()) : null;
		this.itensPedido = pedido.getItensPedido().stream().map(ItemPedidoEntity::new).toList();
		this.precoTotal = pedido.getPrecoTotal();
		this.situacao = pedido.getSituacao();
	}

	public Long getId() {
		return id;
	}

	public String getCodigoPedido() {
		return codigoPedido;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public List<ItemPedidoEntity> getItensPedido() {
		return itensPedido;
	}

	public BigDecimal getPrecoTotal() {
		return precoTotal;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public LocalDateTime getDataHoraCadastro() {
		return dataHoraCadastro;
	}

	@Override
	public String toString() {
		return "PedidoEntity{" +
				"id=" + id +
				", codigoPedido='" + codigoPedido + '\'' +
				", cliente=" + cliente +
				", itensPedido=" + itensPedido +
				", precoTotal=" + precoTotal +
				", situacao=" + situacao +
				", dataHoraCadastro=" + dataHoraCadastro +
				'}';
	}

	public Pedido toPedido() {
		List<ItemPedido> itemPedidos = this.itensPedido.stream().map(ItemPedidoEntity::toItemPedido).toList();
		Cliente cliente = this.cliente != null ? this.cliente.toCliente() : null;
		return new Pedido(this.id, this.codigoPedido, cliente, itemPedidos, this.situacao, this.dataHoraCadastro);
	}
}
