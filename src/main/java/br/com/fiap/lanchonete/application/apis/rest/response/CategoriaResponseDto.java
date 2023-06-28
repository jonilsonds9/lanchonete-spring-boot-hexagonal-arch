package br.com.fiap.lanchonete.application.apis.rest.response;

import br.com.fiap.lanchonete.core.domain.Categoria;

public record CategoriaResponseDto(Long id, String nome) {

    public CategoriaResponseDto(Categoria categoria) {
        this(categoria.getId(), categoria.getNome());
    }
}
