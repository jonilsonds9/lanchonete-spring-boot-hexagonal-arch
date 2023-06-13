package br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import br.com.fiap.lanchonete.utils.Util;
import lombok.Data;

@Data
@Entity
@Table(name = "clientes")
public class ClienteEntity implements Serializable {


	private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "cpf")
    private String CPF;
    
    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private EnderecoEntity endereco;

    @Column(name = "senha")
    private String senha;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "dataNascimento")
    private LocalDate dataNascimento;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "dataCadastro")
    private LocalDate dataCadastro;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "dataAtualizacao")
    private LocalDate  dataAtualizacao;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "dataExclusao")
    private LocalDate dataExclusao;

    @Column(name = "ativo")
    private Boolean ativo;
    
    public ClienteEntity(
    		String cpf, 
    		String nome, 
    		String email, 
    		String telefone, 
    		EnderecoEntity endereco,
			LocalDate dataNascimento, 
			LocalDate dataCadastro, 
			LocalDate dataAtualizacao, 
			LocalDate dataExclusao,
			Boolean ativo) {
		this.CPF = cpf;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
		this.dataCadastro = dataCadastro;
		this.dataAtualizacao = dataAtualizacao;
		this.dataExclusao = dataExclusao;
		this.ativo = ativo;
    	
	}

	public ClienteEntity() {
	}

}
