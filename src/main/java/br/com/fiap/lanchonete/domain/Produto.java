package br.com.fiap.lanchonete.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Produto {

	private Long id;
	private String nome;
	private String descricao;
	private BigDecimal preco;
	private LocalDateTime dataCadastro;
	private boolean disponivel;
	private Categoria categoria;
}
