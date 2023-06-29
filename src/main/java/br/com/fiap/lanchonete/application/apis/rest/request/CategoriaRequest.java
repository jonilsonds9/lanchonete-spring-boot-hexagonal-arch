package br.com.fiap.lanchonete.application.apis.rest.request;

import javax.validation.constraints.*;

public record CategoriaRequest(
        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
        @Pattern(regexp = "^[A-Za-z\\s]*$", message = "O nome só pode conter letras e espaços em branco") String nome) {

    public CategoriaRequest(String nome) {
        this.nome = nome;
    }
}
