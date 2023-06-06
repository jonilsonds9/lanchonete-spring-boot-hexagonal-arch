package br.com.fiap.lanchonete.dtos;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.fiap.lanchonete.entity.Clientes;
import br.com.fiap.lanchonete.entity.Enderecos;
import br.com.fiap.lanchonete.entity.Pedidos;
import br.com.fiap.lanchonete.entity.Produtos;
import br.com.fiap.lanchonete.entity.Pedidos;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PedidosDto {


	private Long id;
	private String codigoPedido;
	private Clientes clientes;
    private Enderecos enderecoEntrega;
	private BigDecimal valorTotal;
	private List<Produtos> produtoSelecionados;

	
	public PedidosDto(Pedidos pedidos) {
		this.id = pedidos.getId();
		this.codigoPedido = pedidos.getCodigoPedido();
		this.clientes = pedidos.getClientes();
		this.enderecoEntrega = pedidos.getEnderecoEntrega();
		this.valorTotal = pedidos.getValorTotal();
		this.produtoSelecionados = pedidos.getProdutoSelecionados();
	}

	public static List<PedidosDto> toDto(List<Pedidos> pedidos) {
		return pedidos.stream().map(PedidosDto::new).collect(Collectors.toList());
	}

	public Pedidos toEntity() {
		Pedidos pedido = new Pedidos();
		pedido.setId(this.getId());
		pedido.setCodigoPedido(this.codigoPedido);
		pedido.setClientes(this.clientes);
		pedido.setEnderecoEntrega(this.enderecoEntrega);
		pedido.setValorTotal(this.valorTotal);
		pedido.setProdutoSelecionados(this.produtoSelecionados);
        return pedido;
	}
	
}
