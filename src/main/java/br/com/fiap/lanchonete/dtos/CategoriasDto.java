package br.com.fiap.lanchonete.dtos;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.com.fiap.lanchonete.entity.Categorias;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoriasDto {

    private Long id;

    @NotBlank(message = "O cpf é obrigatório")
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "Formato de CPF inválido. Use o formato 123.456.789-00")
    private String cpf;
    
    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
    @Pattern(regexp = "^[A-Za-z\\s]*$", message = "O nome não pode conter caracteres especiais")
    private String nome;
    
    public CategoriasDto(Categorias cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
    }

	public static List<CategoriasDto> toDto(List<Categorias> categorias) {
		 return categorias.stream().map(CategoriasDto::new).collect(Collectors.toList());
	}
	
    public Categorias toEntity() {
    	Categorias categorias = new Categorias();
    	categorias.setId(this.getId());
    	categorias.setNome(this.nome);
        return categorias;
    }

}
