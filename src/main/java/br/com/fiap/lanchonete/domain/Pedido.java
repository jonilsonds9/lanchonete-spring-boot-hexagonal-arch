package br.com.fiap.lanchonete.domain;

import java.math.BigDecimal;
import java.util.Map;

public class Pedido {

	private final Long id;
	private final String codigoPedido;
	private final Cliente cliente;
	private final BigDecimal valorTotal;
	private final Map<Produto, Integer> produtos;
	private final Situacao situacao;

	public Pedido(Long id, String codigoPedido, Cliente cliente, BigDecimal valorTotal, Map<Produto,
			Integer> produtos, Situacao situacao) {
		this.id = id;
		this.codigoPedido = codigoPedido;
		this.cliente = cliente;
		this.valorTotal = valorTotal;
		this.produtos = produtos;
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

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public Map<Produto, Integer> getProdutos() {
		return produtos;
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
				", valorTotal=" + valorTotal +
				", produtos=" + produtos +
				", situacao=" + situacao +
				'}';
	}

	public static class PedidoBuilder {
		private Long id;
		private String codigoPedido;
		private Cliente cliente = null;
		private BigDecimal valorTotal;
		private Map<Produto, Integer> produtos;
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

		public PedidoBuilder valorTotal(BigDecimal valorTotal) {
			this.valorTotal = valorTotal;
			return this;
		}

		public PedidoBuilder produtos(Map<Produto, Integer> produtos) {
			this.produtos = produtos;
			return this;
		}

		public PedidoBuilder situacao(Situacao situacao) {
			this.situacao = situacao;
			return this;
		}

		public Pedido build() {
			return new Pedido(this.id, this.codigoPedido, this.cliente, this.valorTotal, this.produtos, this.situacao);
		}
	}
}
