package br.com.fiap.lanchonete.domain;

import java.time.LocalDateTime;

public class Cliente {

    private Long id;
    private final String cpf;
    private final String nome;
    private final String email;
    private final String telefone;
    private LocalDateTime dataHoraCadastro;

    public Cliente(Long id, String cpf, String nome, String email, String telefone, LocalDateTime dataHoraCadastro) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public Cliente(String cpf, String nome, String email, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public LocalDateTime getDataCadastro() {
        return dataHoraCadastro;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataHoraCadastro=" + dataHoraCadastro +
                '}';
    }
}
