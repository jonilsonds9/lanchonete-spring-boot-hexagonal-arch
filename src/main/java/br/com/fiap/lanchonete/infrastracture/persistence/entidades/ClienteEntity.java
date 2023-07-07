package br.com.fiap.lanchonete.infrastracture.persistence.entidades;

import br.com.fiap.lanchonete.domain.Cliente;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "clientes")
public class ClienteEntity implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(unique=true)
    private String cpf;

    private String nome;

    @Column(unique=true)
    private String email;

    private String telefone;

    @CreationTimestamp
    private LocalDateTime dataHoraCadastro;

    @Deprecated
    public ClienteEntity() {
    }

    public ClienteEntity(Cliente cliente) {
        this.cpf = cliente.getCpf();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
    }

    public Cliente toCliente() {
        return new Cliente(this.id, this.cpf, this.nome , this.email, this.telefone, this.dataHoraCadastro);
    }
}
