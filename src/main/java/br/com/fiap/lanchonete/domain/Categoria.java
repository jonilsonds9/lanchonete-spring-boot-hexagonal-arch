package br.com.fiap.lanchonete.domain;

public enum Categoria {

    LANCHE("Lanche"),
    ACOMPANHAMENTO("Acompanhando");

    private final String descricao;

    Categoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
