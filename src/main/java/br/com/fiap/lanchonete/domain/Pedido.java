package br.com.fiap.lanchonete.domain;

import java.math.BigDecimal;
import java.util.List;

public class Pedido {

	private final Long id;
	private final String codigoPedido;
	private final Cliente cliente;
	private final List<ItemPedido> itensPedido;
	private final BigDecimal valorTotal;
	private final Situacao situacao;

	public Pedido(Long id, String codigoPedido, Cliente cliente, List<ItemPedido> itensPedido,
				  BigDecimal valorTotal, Situacao situacao) {
		this.id = id;
		this.codigoPedido = codigoPedido;
		this.cliente = cliente;
		this.itensPedido = itensPedido;
		this.valorTotal = valorTotal;
		this.situacao = situacao;
	}

	public Long getId() {
		return id;
	}

	public String getCodigoPedido() {
		return codigoPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	@Override
	public String toString() {
		return "Pedido{" +
				"id=" + id +
				", codigoPedido='" + codigoPedido + '\'' +
				", cliente=" + cliente +
				", produtos=" + itensPedido +
				", valorTotal=" + valorTotal +
				", situacao=" + situacao +
				'}';
	}

	public static class PedidoBuilder {
		private Long id;
		private String codigoPedido;
		private Cliente cliente = null;
		private List<ItemPedido> itensPedido;
		private BigDecimal valorTotal;
		private Situacao situacao;

		public PedidoBuilder() {
		}

		public PedidoBuilder id(Long id) {
			this.id = id;
			return this;
		}

		public PedidoBuilder codigoPedido(String codigoPedido) {
			this.codigoPedido = codigoPedido;
			return this;
		}

		public PedidoBuilder cliente(Cliente cliente) {
			this.cliente = cliente;
			return this;
		}

		public PedidoBuilder produtosQuantidades(List<ItemPedido> itensPedido) {
			this.itensPedido = itensPedido;
			return this;
		}

		public PedidoBuilder valorTotal(BigDecimal valorTotal) {
			this.valorTotal = valorTotal;
			return this;
		}

		public PedidoBuilder situacao(Situacao situacao) {
			this.situacao = situacao;
			return this;
		}

		public Pedido build() {
			return new Pedido(this.id, this.codigoPedido, this.cliente, this.itensPedido, this.valorTotal,
					this.situacao);
		}
	}
}
