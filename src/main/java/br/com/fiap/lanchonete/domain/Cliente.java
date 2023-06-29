package br.com.fiap.lanchonete.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.fiap.lanchonete.application.apis.rest.request.ClientesDto;
import br.com.fiap.lanchonete.application.apis.rest.request.EnderecoDto;
import br.com.fiap.lanchonete.application.apis.rest.request.LogradouroDto;
import br.com.fiap.lanchonete.infrastracture.persistence.entidades.ClienteEntity;
import br.com.fiap.lanchonete.utils.DateTimeFormattedUtil;
import lombok.Data;

public class Cliente {

    private Long id;
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private LocalDate dataCadastro;
    private LocalDate dataAtualizacao;
}
