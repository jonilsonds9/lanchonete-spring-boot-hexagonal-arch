package br.com.fiap.lanchonete.application.apis.rest.request;

import br.com.fiap.lanchonete.domain.Categoria;
import br.com.fiap.lanchonete.domain.Produto;
import br.com.fiap.lanchonete.domain.Produto.ProdutoBuilder;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public record ProdutoRequestDto(
    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 255, message = "O nome deve ter entre 3 e 50 caracteres")
    @Pattern(regexp = "^[A-Za-z\\s\\d]*$", message = "O nome não pode conter caracteres especiais")
    String nome,

    @NotBlank(message = "A descrição é obrigatório")
    @Size(min = 3, max = 50, message = "A descrição deve ter entre 3 e 50 caracteres")
    @Pattern(regexp = "^[A-Za-z\\s\\d]*$", message = "A descrição não pode conter caracteres especiais")
    String descricao,

    @DecimalMin(value = "0.01", inclusive = true, message = "O valor deve ser maior que 0")
    @Digits(integer = 9, fraction = 2, message = "O valor deve ter no máximo 9 dígitos inteiros e 2 dígitos decimais")
    BigDecimal preco,

    Categoria categoria
) {

    public Produto toProduto() {
        return new ProdutoBuilder()
                .nome(this.nome)
                .descricao(this.descricao)
                .preco(this.preco)
                .categoria(this.categoria)
                .build();
    }
}
