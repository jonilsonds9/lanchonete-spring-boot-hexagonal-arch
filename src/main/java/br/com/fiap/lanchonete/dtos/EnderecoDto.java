package br.com.fiap.lanchonete.dtos;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.com.fiap.lanchonete.entity.Enderecos;
import br.com.fiap.lanchonete.entity.Logradouro;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EnderecoDto {



	private Long id;
    
    private Logradouro logradouro;
    
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
    
    public EnderecoDto(Enderecos endereco) {
		this.id = endereco.getId();
		this.logradouro = endereco.getLogradouro();
		this.endereco = endereco.getEndereco();
		this.numero = endereco.getNumero();
		this.complemento = endereco.getComplemento();
		this.bairro = endereco.getBairro();
		this.cidade = endereco.getCidade();
		this.estado = endereco.getEstado();
		this.cep = endereco.getCep();
	}

	public static Enderecos toEntity(EnderecoDto enderecoDto) {
		Enderecos endereco = new Enderecos();
		
		endereco.setId(enderecoDto.getId());
		endereco.setLogradouro(enderecoDto.getLogradouro());
		endereco.setEndereco(enderecoDto.getEndereco());
		endereco.setNumero(enderecoDto.getNumero());
		endereco.setComplemento(enderecoDto.getComplemento());
		endereco.setBairro(enderecoDto.getBairro());
		endereco.setCidade(enderecoDto.getCidade());
		endereco.setEstado(enderecoDto.getEstado());
		endereco.setCep(enderecoDto.getCep());
		return endereco;
	}
}
