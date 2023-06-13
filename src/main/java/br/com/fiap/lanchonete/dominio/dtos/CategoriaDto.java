package br.com.fiap.lanchonete.dominio.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoriaDto {

    private Long id;
    
    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
    @Pattern(regexp = "^[A-Za-z\\s]*$", message = "O nome não pode conter caracteres especiais")
    private String nome;
    
    public CategoriaDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

}
