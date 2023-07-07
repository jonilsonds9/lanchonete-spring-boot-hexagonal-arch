package br.com.fiap.lanchonete.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Pedido {

	private Long id;
	private String codigoPedido;
	private final Cliente cliente;
	private final List<ItemPedido> itensPedido;
	private final BigDecimal precoTotal;
	private final Situacao situacao;
	private LocalDateTime dataHoraCadastro;

	public Pedido(Long id, String codigoPedido, Cliente cliente, List<ItemPedido> itensPedido, Situacao situacao,
				  LocalDateTime dataHoraCadastro) {
		this.id = id;
		this.codigoPedido = codigoPedido;
		this.cliente = cliente;
		this.itensPedido = itensPedido;
		this.precoTotal = itensPedido.stream().map(ItemPedido::getPrecoTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
		this.situacao = situacao;
		this.dataHoraCadastro = dataHoraCadastro;
	}

	public Pedido(Cliente cliente, List<ItemPedido> itensPedido, Situacao situacao) {
		this.cliente = cliente;
		this.itensPedido = itensPedido;
		this.precoTotal = itensPedido.stream().map(ItemPedido::getPrecoTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
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
		return "Pedido{" +
				"id=" + id +
				", codigoPedido='" + codigoPedido + '\'' +
				", cliente=" + cliente +
				", itensPedido=" + itensPedido +
				", precoTotal=" + precoTotal +
				", situacao=" + situacao +
				", dataHoraCadastro=" + dataHoraCadastro +
				'}';
	}

	public static class PedidoBuilder {
		private Cliente cliente = null;
		private List<ItemPedido> itensPedido;
		private Situacao situacao = Situacao.RECEBIDO;

		public PedidoBuilder() {
		}

		public PedidoBuilder cliente(Cliente cliente) {
			this.cliente = cliente;
			return this;
		}

		public PedidoBuilder itensPedido(List<ItemPedido> itensPedido) {
			this.itensPedido = itensPedido;
			return this;
		}

		public PedidoBuilder situacao(Situacao situacao) {
			this.situacao = situacao;
			return this;
		}

		public Pedido build() {
			return new Pedido(this.cliente, this.itensPedido, this.situacao);
		}
	}
}
