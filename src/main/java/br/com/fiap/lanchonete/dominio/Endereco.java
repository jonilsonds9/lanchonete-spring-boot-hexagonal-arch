package br.com.fiap.lanchonete.dominio;

import br.com.fiap.lanchonete.dominio.dtos.EnderecoDto;
import br.com.fiap.lanchonete.dominio.dtos.LogradouroDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Endereco {

    private Long id;
    private Logradouro logradouro;
    private String endereco;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    
	public static EnderecoDto toEnderecoDto(LogradouroDto logradouroDto, 
			Long id, 
			String endereco, 
			String numero,
			String complemento, 
			String bairro, 
			String cidade, 
			String estado, 
			String cep) {
		return new EnderecoDto(
				id, 
				logradouroDto, 
				endereco,
				numero,
				complemento,
				bairro,
				cidade,
				estado,
				cep);
	}

	public static Endereco toEndereco(Logradouro logradouro, 
			Long id, 
			String endereco, 
			String numero,
			String complemento, 
			String bairro, 
			String cidade, 
			String estado, 
			String cep) {
		return new Endereco(
				id, 
				logradouro, 
				endereco,
				numero,
				complemento,
				bairro,
				cidade,
				estado,
				cep);
	}

	public Endereco(EnderecoDto enderecoDto) {
		// TODO Auto-generated constructor stub
	}

}
