package br.com.fiap.lanchonete.dominio.dtos.categorias;

import javax.validation.constraints.*;

public class CategoriaRequestDto {

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
    @Pattern(regexp = "^[A-Za-z\\s]*$", message = "O nome não pode conter caracteres especiais")
    private final String nome;

    public CategoriaRequestDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
