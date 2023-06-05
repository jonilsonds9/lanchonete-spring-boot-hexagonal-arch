package br.com.fiap.lanchonete.dtos;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.com.fiap.lanchonete.Util;
import br.com.fiap.lanchonete.entity.Clientes;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientesDto {
	
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
    @Pattern(regexp = "^[A-Za-z\\s]*$", message = "O nome não pode conter caracteres especiais")
    private String nome;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "O e-mail deve ser válido")
    private String email;

    @NotBlank(message = "O telefone é obrigatório")
    @Pattern(regexp = "\\([0-9]{2}\\)\\s[0-9]{4,5}-[0-9]{4}", message = "Formato de telefone inválido. Use o formato (99) 99999-9999")
    private String telefone;

    @NotBlank(message = "O endereço é obrigatório")
    private String endereco;

    @NotBlank(message = "O CEP é obrigatório")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "Formato de CEP inválido. Use o formato 12345-678")
    private String cep;

    @NotBlank(message = "O cpf é obrigatório")
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "Formato de CPF inválido. Use o formato 123.456.789-00")
    private String cpf;

    private String senha;

    @NotBlank(message = "A data de nascimento é obrigatória")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "A data de nascimento deve estar no formato yyyy-MM-dd")
    private String dataNascimento;

    private LocalDate dataCadastro;
    private LocalDate dataAtualizacao;
    private LocalDate dataExclusao;
    
    private Boolean ativo;

    public ClientesDto(Clientes cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
        this.endereco = cliente.getEndereco();
        this.cpf = cliente.getCPF();
        this.senha = cliente.getSenha();
        this.dataNascimento = Util.dataToString(cliente.getDataNascimento());
        this.dataCadastro = cliente.getDataCadastro();
        this.dataAtualizacao = cliente.getDataAtualizacao();
        this.dataExclusao = cliente.getDataExclusao();
        this.ativo = cliente.getAtivo();
    }

    public static List<ClientesDto> toDto(List<Clientes> clientes) {
        return clientes.stream().map(ClientesDto::new).collect(Collectors.toList());
    }

    public Clientes toEntity() {
        Clientes cliente = new Clientes();
        cliente.setId(this.getId());
        cliente.setNome(this.nome);
        cliente.setEmail(this.email);
        cliente.setTelefone(this.telefone);
        cliente.setEndereco(this.endereco);
        cliente.setCPF(this.cpf);
        cliente.setSenha(this.senha);
        cliente.setDataNascimento(Util.stringToData(this.dataNascimento));
        cliente.setDataCadastro(this.dataCadastro);
        cliente.setDataAtualizacao(this.dataAtualizacao);
        cliente.setDataExclusao(this.dataExclusao);
        cliente.setAtivo(this.ativo);
        return cliente;
    }

}
