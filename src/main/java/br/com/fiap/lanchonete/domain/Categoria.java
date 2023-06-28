package br.com.fiap.lanchonete.domain;

import br.com.fiap.lanchonete.application.apis.rest.request.CategoriaRequestDto;
import br.com.fiap.lanchonete.application.apis.rest.response.CategoriaResponseDto;
import br.com.fiap.lanchonete.infrastracture.persistence.entidades.CategoriaEntity;
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
