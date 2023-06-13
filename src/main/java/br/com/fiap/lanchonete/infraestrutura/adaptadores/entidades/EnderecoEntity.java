package br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "endereco")
public class EnderecoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    
    @JoinColumn(name = "logradouro")
    private LogradouroEntity logradouro;
    
    @Column(name = "endereco")
    private String endereco;
    
    @Column(name = "numero")
    private String numero;
    
    @Column(name = "complemento")
    private String complemento;
    
    @Column(name = "bairro")
    private String bairro;
    
    @Column(name = "cidade")
    private String cidade;
    
    @Column(name = "estado")
    private String estado;
    
    @Column(name = "cep")
    private String cep;
    
    public EnderecoEntity(LogradouroEntity logradouroEntity, 
    		Long id, String endereco, String numero,
			String complemento, String bairro, String cidade, String estado, String cep) {
		super();
		this.id = id;
		this.logradouro = logradouroEntity;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}


}
