package br.com.fiap.lanchonete.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.fiap.lanchonete.dtos.ClientesDto;
import br.com.fiap.lanchonete.entity.Clientes;
import br.com.fiap.lanchonete.exceptions.GenericException;
import br.com.fiap.lanchonete.exceptions.ResponseHandler;
import br.com.fiap.lanchonete.repository.ClientesRepository;
import br.com.fiap.lanchonete.service.ClientesService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Qualifier("clientePostgresService")
public class ClientesServiceImpl implements ClientesService {

	@Autowired
	private ClientesRepository clienteRepository;

	@Override
	public ResponseEntity<Object> findAll() {
		try {
			log.info("Pesquisar todos os clientes");
			List<Clientes> clientes = clienteRepository.findAll();

			if(clientes.isEmpty()) {
				return ResponseHandler.generateResponse("Dado não encontrado!", HttpStatus.NO_CONTENT, ClientesDto.toDto(clientes));
			}
			
			return ResponseHandler.generateResponse("Dado encontrado!", HttpStatus.OK, ClientesDto.toDto(clientes));
			
		} catch (GenericException e) {
			log.error("Erro ao pesquisar todos os clientes", e);
			return ResponseHandler.generateResponse("Erro ao pesquisar a lista de clientes!", HttpStatus.FAILED_DEPENDENCY, null);
		}
	}

	@Override
	public ResponseEntity<Object>  incluir(ClientesDto clienteDto) {
		try {
			log.info("Incluindo cliente");
			
			Clientes clientes = clienteRepository.findByCPF(clienteDto.getCpf());
					
			if (clientes != null) {
				return ResponseHandler.generateResponse("Cliente já está cadastrado no sistemo!", HttpStatus.BAD_REQUEST, clienteDto);
			}

			clienteDto.setAtivo(true);
			clienteDto.setDataCadastro(LocalDate.now());

			Clientes clienteIncluido = clienteRepository.save(clienteDto.toEntity());

			if (clienteIncluido == null) {
				return ResponseHandler.generateResponse("Dado não encontrado!", HttpStatus.NOT_ACCEPTABLE, clienteDto);
			}
			
			return ResponseHandler.generateResponse("Cliente já está cadastrado!", HttpStatus.CREATED, new ClientesDto(clienteIncluido));
			
		} catch (Exception e) {
			log.error("Erro ao incluir cliente", e);
			
			return ResponseHandler.generateResponse("Erro ao incluir o cliente!", HttpStatus.FAILED_DEPENDENCY, null);
		}
	}

	@Override
	public ResponseEntity<Object>  alterar(ClientesDto clienteDtoRequest) {
		try {
			log.info("Alterando cliente");
			Clientes cliente = clienteRepository.findById(clienteDtoRequest.getId()).orElse(null);

			if (cliente == null) {
				log.info("Cliente não encontrado");
				return ResponseHandler.generateResponse("Cliente não encontrado!", HttpStatus.NOT_FOUND, clienteDtoRequest);
			}

			clienteDtoRequest.setId(cliente.getId());
			clienteDtoRequest.setDataAtualizacao(LocalDate.now());

			Clientes clienteAlterado = clienteRepository.save(clienteDtoRequest.toEntity());

			if (clienteAlterado == null) {				
				log.info("Cliente não alterado");
				return ResponseHandler.generateResponse("Cliente não alterado!", HttpStatus.NOT_ACCEPTABLE, clienteDtoRequest);
			}
			
			return ResponseHandler.generateResponse("Cliente alterado com sucesso!", HttpStatus.OK , new ClientesDto(clienteAlterado));
		} catch (Exception e) {
			log.error("Erro ao alterar cliente", e);
			return ResponseHandler.generateResponse("Erro ao alterar o cliente!", HttpStatus.FAILED_DEPENDENCY, null);
		}
	}

	@Override
	public ResponseEntity<Object> excluir(Long id) {
		try {
			log.info("Excluindo cliente");
			Clientes cliente = clienteRepository.findById(id).orElse(null);

			if (cliente == null) {
				log.info("Cliente não encontrado");
				return ResponseHandler.generateResponse("Cliente não alterado!", HttpStatus.NOT_ACCEPTABLE, id);
			}

			clienteRepository.deleteById(id);
			log.info("Cliente excluido com sucesso");
			return ResponseHandler.generateResponse("Cliente excluido com sucesso!", HttpStatus.OK , cliente);
		} catch (Exception e) {
			log.error("Erro ao excluir cliente", e);
			return ResponseHandler.generateResponse("Erro ao excluir o cliente!", HttpStatus.FAILED_DEPENDENCY, null);
		}
	}

	@Override
	public ResponseEntity<Object>  findByCPF(String cpf) {
		try {
			log.info("Pesquisar clientes por CPF");
			Clientes cliente = clienteRepository.findByCPF(cpf);

			if (cliente == null) {
				log.info("Cliente encontrado");
				return ResponseHandler.generateResponse("Cliente não encontrado!", HttpStatus.NOT_FOUND, cpf);
			}

			log.info("Clientes encontrados");
			return ResponseHandler.generateResponse("Cliente encontrado!", HttpStatus.OK , new ClientesDto(cliente));

		} catch (GenericException e) {
			log.error("Erro ao pesquisar todos os clientes", e);
			return ResponseHandler.generateResponse("Erro ao pesquisar o cliente por CPF!", HttpStatus.FAILED_DEPENDENCY, null);
		}
	}

}
