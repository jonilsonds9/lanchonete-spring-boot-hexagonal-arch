package br.com.fiap.lanchonete.domain;

import br.com.fiap.lanchonete.domain.validations.NotBlank;

import java.time.LocalDate;

public class Cliente {

    private final Long id;

    @NotBlank // TODO: Arrumar validação!
    private final String cpf;
    private final String nome;
    private final String email;
    private final String telefone;
    private final LocalDate dataCadastro;
    private final LocalDate dataAtualizacao;

    public Cliente(Long id, String cpf, String nome, String email, String telefone, LocalDate dataCadastro,
                   LocalDate dataAtualizacao) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
    }

    public Cliente(String cpf, String nome, String email, String telefone, LocalDate dataCadastro, LocalDate dataAtualizacao) {
        this(null, cpf, nome, email, telefone, dataCadastro, dataAtualizacao);
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

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", dataAtualizacao=" + dataAtualizacao +
                '}';
    }

    public static class ClienteBuilder {
        private Long id;
        private String cpf;
        private String nome;
        private String email;
        private String telefone;
        private LocalDate dataCadastro;
        private LocalDate dataAtualizacao;

        public ClienteBuilder() {
        }

        public ClienteBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ClienteBuilder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public ClienteBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public ClienteBuilder email(String email) {
            this.email = email;
            return this;
        }

        public ClienteBuilder telefone(String telefone) {
            this.telefone = telefone;
            return this;
        }

        public ClienteBuilder dataCadastro(LocalDate dataCadastro) {
            this.dataCadastro = dataCadastro;
            return this;
        }

        public ClienteBuilder dataAtualizacao(LocalDate dataAtualizacao) {
            this.dataAtualizacao = dataAtualizacao;
            return this;
        }

        public Cliente build() {
            Cliente cliente = new Cliente(this.id, this.cpf, this.nome, this.email, this.telefone, this.dataCadastro, this.dataAtualizacao);
            return cliente;
        }
    }
}
