package br.com.fiap.lanchonete.infrastracture.apis.rest.request;

import br.com.fiap.lanchonete.infrastracture.apis.rest.validations.UniqueCpf;
import br.com.fiap.lanchonete.infrastracture.apis.rest.validations.UniqueEmail;
import br.com.fiap.lanchonete.domain.Cliente;

import javax.validation.constraints.*;

public record ClienteRequestDto(
        @NotBlank(message = "O cpf é obrigatório")
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "Formato de CPF inválido. Use o formato 123.456.789-00")
        @UniqueCpf
        String cpf,

        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
        @Pattern(regexp = "^[A-Za-z\\s]*$", message = "O nome não pode conter caracteres especiais")
        String nome,

        @NotBlank(message = "O email é obrigatório")
        @Email(message = "O e-mail deve ser válido")
        @UniqueEmail
        String email,

        @NotBlank(message = "O telefone é obrigatório")
        @Pattern(regexp = "\\([0-9]{2}\\)\\s[0-9]{4,5}-[0-9]{4}", message = "Formato de telefone inválido. Use o formato (99) 99999-9999")
        String telefone) {

    public Cliente toCliente() {
        return new Cliente(this.cpf, this.nome , this.email, this.telefone);
    }
}
