package br.com.fiap.lanchonete.dominio.dtos;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.com.fiap.lanchonete.utils.DateTimeFormattedUtil;
import lombok.Data;

@Data
public class ClientesDto {
	
	private Long id;

    @NotBlank(message = "O cpf é obrigatório")
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "Formato de CPF inválido. Use o formato 123.456.789-00")
    private String cpf;
    
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

    private EnderecoDto endereco;

    @NotBlank(message = "A data de nascimento é obrigatória")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "A data de nascimento deve estar no formato yyyy-MM-dd")
    private String dataNascimento;

    private LocalDate dataCadastro;
    private LocalDate dataAtualizacao;
    private LocalDate dataExclusao;
    
    private Boolean ativo;

	public ClientesDto(
			Long id,
			String cpf,
			String nome,
			String email,
			String telefone,
			EnderecoDto endereco,
			LocalDate dataNascimento,
			LocalDate dataCadastro, 
			LocalDate dataAtualizacao, LocalDate dataExclusao, Boolean ativo) {
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.dataNascimento = DateTimeFormattedUtil.dataToString(dataNascimento);
		this.dataCadastro = dataCadastro;
		this.dataAtualizacao = dataAtualizacao;
		this.dataExclusao = dataExclusao;
		this.ativo = ativo;
	}


    
    
    

//    public ClientesDto(ClienteEntity cliente) {    	
//        this.id = cliente.getId();
//        this.nome = cliente.getNome();
//        this.email = cliente.getEmail();
//        this.telefone = cliente.getTelefone();
//       // this.endereco = new EnderecoDto(cliente.getEndereco());
//        this.cpf = cliente.getCPF();
//        this.dataNascimento = Util.dataToString(cliente.getDataNascimento());
//        this.dataCadastro = cliente.getDataCadastro();
//        this.dataAtualizacao = cliente.getDataAtualizacao();
//        this.dataExclusao = cliente.getDataExclusao();
//        this.ativo = cliente.getAtivo();
//    }
//
//    public static List<ClientesDto> toDto(List<ClienteEntity> clientes) {
//        return clientes.stream().map(ClientesDto::new).collect(Collectors.toList());
//    }
//
//    public ClienteEntity toEntity() {
//        ClienteEntity cliente = new ClienteEntity();
//        cliente.setId(this.getId());
//        cliente.setNome(this.nome);
//        cliente.setEmail(this.email);
//        cliente.setTelefone(this.telefone);
//       // cliente.setEndereco( EnderecoDto.toEntity(this.endereco));
//        cliente.setCPF(this.cpf);
//        cliente.setDataNascimento(Util.stringToData(this.dataNascimento));
//        cliente.setDataCadastro(this.dataCadastro);
//        cliente.setDataAtualizacao(this.dataAtualizacao);
//        cliente.setDataExclusao(this.dataExclusao);
//        cliente.setAtivo(this.ativo);
//        return cliente;
//    }

}
