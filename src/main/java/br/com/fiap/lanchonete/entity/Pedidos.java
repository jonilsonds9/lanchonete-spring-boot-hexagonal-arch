package br.com.fiap.lanchonete.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "pedidos")
public class Pedidos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	
	@Column(name = "codigoPedido")
	private String codigoPedido;
	
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "cliente")
//    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Clientes clientes;
	
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "produtoSelecionados")
//    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
//	private List<ProdutoSelecionados> produtos;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@Column(name = "valorTotal")
	private BigDecimal valorTotal;
	

}
