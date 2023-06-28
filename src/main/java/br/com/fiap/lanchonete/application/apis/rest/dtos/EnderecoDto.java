package br.com.fiap.lanchonete.application.apis.rest.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EnderecoDto {

	private Long id;
    
    private LogradouroDto logradouro;
    
    @NotBlank(message = "O endereço é obrigatório")
    @Size(min = 3, max = 50, message = "O endereço deve ter entre 3 e 50 caracteres")
    @Pattern(regexp = "^[A-Za-z\\s]*$", message = "O endereço não pode conter caracteres especiais")
    private String endereco;

    @NotBlank(message = "O número é obrigatório")
    @Size(min = 3, max = 10, message = "O número deve ter entre 3 e 50 caracteres")
    @Pattern(regexp = "^[A-Za-z\\s]*$", message = "O número não pode conter caracteres especiais")
    private String numero;

    private String complemento;

    @NotBlank(message = "O bairro é obrigatório")
    @Size(min = 3, max = 25, message = "O bairro deve ter entre 3 e 50 caracteres")
    @Pattern(regexp = "^[A-Za-z\\s]*$", message = "O bairro não pode conter caracteres especiais")
    private String bairro;

    @NotBlank(message = "O cidade é obrigatório")
    @Size(min = 3, max = 25, message = "O cidade deve ter entre 3 e 50 caracteres")
    @Pattern(regexp = "^[A-Za-z\\s]*$", message = "O cidade não pode conter caracteres especiais")
    private String cidade;
    
    @NotBlank(message = "O estado é obrigatório")
    @Size(min = 3, max = 25, message = "O estado deve ter entre 3 e 50 caracteres")
    @Pattern(regexp = "^[A-Za-z\\s]*$", message = "O estado não pode conter caracteres especiais")    
    private String estado;
	
    @NotBlank(message = "O CEP é obrigatório")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "Formato de CEP inválido. Use o formato 12345-678")
    private String cep;

	public EnderecoDto(Long id, 
			LogradouroDto logradouro,
			String endereco,
			String numero,
			String complemento,
			String bairro,
			String cidade,
			String estado,
			String cep) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}
}
