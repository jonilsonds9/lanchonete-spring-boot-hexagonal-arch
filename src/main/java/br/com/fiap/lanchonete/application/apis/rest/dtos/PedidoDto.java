package br.com.fiap.lanchonete.application.apis.rest.dtos;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PedidoDto {


	private Long id;
	private String codigoPedido;
	private ClientesDto clientes;
    private EnderecoDto enderecoEntrega;
	private BigDecimal valorTotal;
	private List<ProdutosDto> produtoSelecionados;
	
	public PedidoDto(Long id, String codigoPedido, ClientesDto clientes, 
			EnderecoDto enderecoEntrega,
			BigDecimal valorTotal, List<ProdutosDto> produtoSelecionados) {
		super();
		this.id = id;
		this.codigoPedido = codigoPedido;
		this.clientes = clientes;
		this.enderecoEntrega = enderecoEntrega;
		this.valorTotal = valorTotal;
		this.produtoSelecionados = produtoSelecionados;
	}

	
	
}
