package br.com.fiap.lanchonete.infrastracture.apis.rest.response;

import br.com.fiap.lanchonete.domain.Categoria;
import br.com.fiap.lanchonete.domain.Produto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProdutoResponseDto(Long id, String nome, String descricao, BigDecimal preco, LocalDateTime dataCadastro,
                                 Categoria categoria) {

    public ProdutoResponseDto(Produto produto) {
        this(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getDataCadastro(),
                produto.getCategoria());
    }
}
