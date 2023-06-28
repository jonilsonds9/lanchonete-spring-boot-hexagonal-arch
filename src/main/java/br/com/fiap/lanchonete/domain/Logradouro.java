package br.com.fiap.lanchonete.domain;

import br.com.fiap.lanchonete.application.apis.rest.request.LogradouroDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Logradouro {

    private Long id;
    private String nome;
    
	public static LogradouroDto toLogradouroDto(Long id, String nome) {
		return new LogradouroDto(id, nome);
	}

	public static Logradouro toLogradouro(Long id, String nome) {
		return new Logradouro(id, nome);
	}
}
