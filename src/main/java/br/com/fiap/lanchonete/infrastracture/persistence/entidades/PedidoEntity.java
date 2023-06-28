package br.com.fiap.lanchonete.infrastracture.persistence.entidades;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "pedidos")
public class PedidoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	
	@Column(name = "codigoPedido")
	private String codigoPedido;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private ClienteEntity clientes;
    
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "enderecoEntrega")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private EnderecoEntity enderecoEntrega;
	
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "produtoSelecionados")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private List<ProdutoEntity> produtoSelecionados;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@Column(name = "valorTotal")
	private BigDecimal valorTotal;
	
}
