package br.com.fiap.lanchonete.infrastracture.databases.postgres.entidades;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.fiap.lanchonete.core.domain.Categoria;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "categorias")
public class CategoriaEntity implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    public CategoriaEntity(Long id, String nome) {
    	this.id = id;
    	this.nome = nome;
	}
    
    public CategoriaEntity(String nome) {
    	this.nome = nome;
	}

    public CategoriaEntity(Categoria categoria) {
        this(categoria.getNome());
    }
}
