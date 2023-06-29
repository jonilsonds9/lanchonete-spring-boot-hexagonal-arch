package br.com.fiap.lanchonete.domain;

import java.math.BigDecimal;
import java.util.*;

import lombok.Data;

@Data
public class Pedido {

	private Long id;
	private String codigoPedido;
	private Cliente cliente = null;
	private BigDecimal valorTotal;
	private Map<Produto, Integer> produtos;
	private Situacao situacao;
}
