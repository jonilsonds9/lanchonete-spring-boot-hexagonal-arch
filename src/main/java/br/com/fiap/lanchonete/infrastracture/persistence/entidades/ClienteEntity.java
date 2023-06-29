package br.com.fiap.lanchonete.infrastracture.persistence.entidades;

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

import br.com.fiap.lanchonete.domain.Cliente;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import lombok.*;

@Entity
@Table(name = "clientes")
public class ClienteEntity implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String cpf;

    private String nome;

    private String email;

    private String telefone;

    private LocalDate dataCadastro;

    private LocalDate  dataAtualizacao;

    public ClienteEntity(String cpf, String nome, String email, String telefone, LocalDate dataCadastro,
			LocalDate dataAtualizacao) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.dataCadastro = dataCadastro;
		this.dataAtualizacao = dataAtualizacao;
	}

    public ClienteEntity(Cliente cliente) {
        this(cliente.getCpf(), cliente.getNome(), cliente.getEmail(),
                cliente.getTelefone(), cliente.getDataCadastro(), cliente.getDataAtualizacao());
    }

    @Deprecated
	public ClienteEntity() {
	}

    public Cliente toCliente() {
        return new Cliente(this.id, this.cpf, this.nome , this.email, this.telefone, this.dataCadastro,
                this.dataAtualizacao);
    }
}
