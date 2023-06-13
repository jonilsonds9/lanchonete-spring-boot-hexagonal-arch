package br.com.fiap.lanchonete.dominio.dtos;

import lombok.Data;

@Data
public class LogradouroDto {

	private Long id;
	private String nome;

	public LogradouroDto(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

}
