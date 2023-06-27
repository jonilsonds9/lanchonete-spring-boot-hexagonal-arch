package br.com.fiap.lanchonete.dominio.dtos.categorias;

import br.com.fiap.lanchonete.dominio.Categoria;

public record CategoriaResponseDto(Long id, String nome) {

    public CategoriaResponseDto(Categoria categoria) {
        this(categoria.getId(), categoria.getNome());
    }
}
