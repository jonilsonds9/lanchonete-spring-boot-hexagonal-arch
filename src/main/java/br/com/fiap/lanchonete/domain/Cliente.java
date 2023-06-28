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

@Data
public class Cliente {

    private Long id;
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private Endereco endereco;
    private LocalDate dataNascimento;
    private LocalDate dataCadastro;
    private LocalDate dataAtualizacao;
    private LocalDate dataExclusao;
    private Boolean ativo;
 
	public Cliente(Long id, String cpf, String nome, String email, String telefone, Endereco endereco,
			LocalDate dataNascimento, LocalDate dataCadastro, LocalDate dataAtualizacao, LocalDate dataExclusao,
			Boolean ativo) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
		this.dataCadastro = dataCadastro;
		this.dataAtualizacao = dataAtualizacao;
		this.dataExclusao = dataExclusao;
		this.ativo = ativo;
	}
    
    
    
    public ClientesDto toClienteDTO() {
        
		LogradouroDto logradouroDto = Logradouro.toLogradouroDto(this.endereco.getLogradouro().getId(), this.endereco.getLogradouro().getNome());		
		EnderecoDto enderecoDto = Endereco.toEnderecoDto(logradouroDto, 
				this.endereco.getId(),
				this.endereco.getEndereco(),
				this.endereco.getNumero(),
				this.endereco.getComplemento(),
				this.endereco.getBairro(),
				this.endereco.getCidade(),
				this.endereco.getEstado(),
				this.endereco.getCep());

    	
    	return new ClientesDto(
        		this.id,
        		this.cpf,
        		this.nome, 
        		this.email, 
        		this.telefone,
        		enderecoDto, 
        		this.dataNascimento, 
        		this.dataCadastro,
        		this.dataAtualizacao,
        		this.dataExclusao,
        		this.ativo);
    }
    
    
    public Cliente toCliente() {
        return new Cliente(
        		this.id,
        		this.cpf,
        		this.nome, 
        		this.email, 
        		this.telefone,
        		this.endereco, 
        		this.dataNascimento, 
        		this.dataCadastro,
        		this.dataAtualizacao,
        		this.dataExclusao,
        		this.ativo);
    }
    
	public static List<Cliente> toClientes(List<ClienteEntity> clienteEntities) {
		return clienteEntities.stream().map(Cliente::new).collect(Collectors.toList());
	}


	public Cliente(ClienteEntity clienteEntity) {
		super();
		Logradouro logradouro = Logradouro.toLogradouro(clienteEntity.getEndereco().getLogradouro().getId(), clienteEntity.getEndereco().getLogradouro().getNome() );		
		Endereco endereco = Endereco.toEndereco(logradouro, 
				clienteEntity.getEndereco().getId(),
				clienteEntity.getEndereco().getEndereco(),
				clienteEntity.getEndereco().getNumero(),
				clienteEntity.getEndereco().getComplemento(),
				clienteEntity.getEndereco().getBairro(),
				clienteEntity.getEndereco().getCidade(),
				clienteEntity.getEndereco().getEstado(),
				clienteEntity.getEndereco().getCep());
		
		this.id = clienteEntity.getId();
		this.cpf = clienteEntity.getCPF();
		this.nome = clienteEntity.getNome();
		this.email = clienteEntity.getEmail();
		this.telefone = clienteEntity.getTelefone();
		this.endereco = endereco;
		this.dataNascimento = clienteEntity.getDataNascimento();
		this.dataCadastro = clienteEntity.getDataCadastro();
		this.dataAtualizacao = clienteEntity.getDataAtualizacao();
		this.dataExclusao = clienteEntity.getDataExclusao();
		this.ativo = clienteEntity.getAtivo();
	}



	public Cliente(ClientesDto clientesDto) {
		Logradouro logradouro = Logradouro.toLogradouro(clientesDto.getEndereco().getLogradouro().getId(), clientesDto.getEndereco().getLogradouro().getNome());		
		Endereco endereco = Endereco.toEndereco(logradouro, 
				clientesDto.getEndereco().getId(),
				clientesDto.getEndereco().getEndereco(),
				clientesDto.getEndereco().getNumero(),
				clientesDto.getEndereco().getComplemento(),
				clientesDto.getEndereco().getBairro(),
				clientesDto.getEndereco().getCidade(),
				clientesDto.getEndereco().getEstado(),
				clientesDto.getEndereco().getCep());
		
		this.id = clientesDto.getId();
		this.cpf = clientesDto.getCpf();
		this.nome = clientesDto.getNome();
		this.email = clientesDto.getEmail();
		this.telefone = clientesDto.getTelefone();
		this.endereco = endereco;
		this.dataNascimento = DateTimeFormattedUtil.stringToData(clientesDto.getDataNascimento()) ;
		this.dataCadastro = clientesDto.getDataCadastro();
		this.dataAtualizacao = clientesDto.getDataAtualizacao();
		this.dataExclusao = clientesDto.getDataExclusao();
		this.ativo = clientesDto.getAtivo();
	}



	public static ClientesDto toClienteDto(Cliente cliente) {
		LogradouroDto logradouroDto = Logradouro.toLogradouroDto(cliente.getEndereco().getLogradouro().getId(), cliente.getEndereco().getLogradouro().getNome());		
		EnderecoDto enderecoDto = Endereco.toEnderecoDto(logradouroDto, 
				cliente.getEndereco().getId(),
				cliente.getEndereco().getEndereco(),
				cliente.getEndereco().getNumero(),
				cliente.getEndereco().getComplemento(),
				cliente.getEndereco().getBairro(),
				cliente.getEndereco().getCidade(),
				cliente.getEndereco().getEstado(),
				cliente.getEndereco().getCep());

    	
    	return new ClientesDto(
				cliente.getId(),
        		cliente.getCpf(),
        		cliente.getNome(), 
        		cliente.getEmail(), 
        		cliente.getTelefone(),
        		enderecoDto, 
        		cliente.getDataNascimento(), 
        		cliente.getDataCadastro(),
        		cliente.getDataAtualizacao(),
        		cliente.getDataExclusao(),
        		cliente.getAtivo());
	}    
}
