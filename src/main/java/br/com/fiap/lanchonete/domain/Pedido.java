package br.com.fiap.lanchonete.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.lanchonete.application.apis.rest.request.ClientesDto;
import br.com.fiap.lanchonete.application.apis.rest.request.EnderecoDto;
import br.com.fiap.lanchonete.application.apis.rest.request.PedidoDto;
import br.com.fiap.lanchonete.application.apis.rest.request.ProdutosDto;
import br.com.fiap.lanchonete.infrastracture.persistence.entidades.PedidoEntity;
import lombok.Data;

@Data
public class Pedido {

	private Long id;
	private String codigoPedido;
	private Cliente clientes;
	private Endereco enderecoEntrega;
	private BigDecimal valorTotal;
	private List<Produto> produtoSelecionados;

	public Pedido(Long id, String codigoPedido, Cliente clientes, Endereco enderecoEntrega, BigDecimal valorTotal,
			List<Produto> produtoSelecionados) {
		super();
		this.id = id;
		this.codigoPedido = codigoPedido;
		this.clientes = clientes;
		this.enderecoEntrega = enderecoEntrega;
		this.valorTotal = valorTotal;
		this.produtoSelecionados = produtoSelecionados;
	}

	public Pedido(PedidoDto pedidoDto) {
		Cliente cliente = new Cliente(pedidoDto.getClientes());
		Endereco enderecoEntrega = new Endereco(pedidoDto.getEnderecoEntrega());
	    List<Produto> produtoSelecionados = new ArrayList<>();
				
				
		this.id = pedidoDto.getId();
		this.codigoPedido = pedidoDto.getCodigoPedido();
		this.clientes = cliente;
		this.enderecoEntrega = enderecoEntrega;
		this.valorTotal = pedidoDto.getValorTotal();
		this.produtoSelecionados = produtoSelecionados;
					
	}

	public static PedidoDto toPedidoDto(Long id, String codigoPedido, ClientesDto clientes,
			EnderecoDto enderecoEntrega, BigDecimal valorTotal, List<ProdutosDto> produtoSelecionados) {
		return new PedidoDto(id, codigoPedido, clientes, enderecoEntrega, valorTotal, produtoSelecionados);
	}

	public static List<Pedido> toPedidos(List<PedidoEntity> pedidoEntities) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static PedidoDto toPedidoDto(Pedido pedido) {
		ClientesDto clienteDto = Cliente.toClienteDto(pedido.getClientes());
		EnderecoDto enderecoDto = clienteDto.getEndereco();
		
		List<ProdutosDto> produtoSelecionados = new ArrayList<>();
		
		return new PedidoDto(
				pedido.getId(), 
				pedido.getCodigoPedido(), 
				clienteDto, 
				enderecoDto,
				pedido.getValorTotal(), 
				produtoSelecionados);
	}

}
