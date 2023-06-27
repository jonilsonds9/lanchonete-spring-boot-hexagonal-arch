package br.com.fiap.lanchonete.dominio;

import br.com.fiap.lanchonete.dominio.dtos.categorias.CategoriaRequestDto;
import br.com.fiap.lanchonete.dominio.dtos.categorias.CategoriaResponseDto;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.CategoriaEntity;
import lombok.Getter;

@Getter
public class Categoria {

    private Long id;    
    private String nome;

	public Categoria(String nome) {
		this.nome = nome;
	}

	public Categoria(CategoriaRequestDto categoriaRequestDto) {
		this(categoriaRequestDto.nome());
	}

	public Categoria(CategoriaEntity categoriaEntity) {
		this.id = categoriaEntity.getId();
		this.nome = categoriaEntity.getNome();
	}

	public CategoriaResponseDto toCategoriaResponseDto() {
		return new CategoriaResponseDto(this.id, this.nome);
	}

	public void atualizar(CategoriaRequestDto categoriaRequestDto) {
		this.nome = categoriaRequestDto.nome();
	}
}
