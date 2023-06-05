package br.com.fiap.lanchonete.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.fiap.lanchonete.dtos.ClientesDto;
import br.com.fiap.lanchonete.entity.Clientes;
import br.com.fiap.lanchonete.exceptions.GenericException;
import br.com.fiap.lanchonete.repository.ClientesRepository;
import br.com.fiap.lanchonete.service.ClientesService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Qualifier("autorPostgresService")
public class ClientesServiceImpl implements ClientesService {

	@Autowired
	private ClientesRepository clienteRepository;

	@Override
	public List<ClientesDto> findAll() {
		try {
			log.info("Pesquisar todos os clientes");
			List<Clientes> clientes = clienteRepository.findAll();

			if (clientes.isEmpty()) {
				log.info("Nenhum cliente encontrado");
				throw new GenericException("Nenhum cliente encontrado");
			}

			log.info("Clientes encontrados");
			return ClientesDto.toDto(clientes);

		} catch (GenericException e) {
			log.error("Erro ao pesquisar todos os clientes", e);
			throw new GenericException("Erro ao pesquisar todos os clientes.");
		}
	}

	@Override
	public ClientesDto incluir(ClientesDto clienteDto) {
		try {
			log.info("Incluindo cliente");

			clienteDto.setAtivo(true);
			clienteDto.setDataCadastro(LocalDate.now());

			Clientes clienteIncluido = clienteRepository.save(clienteDto.toEntity());

			if (clienteIncluido != null) {
				log.info("Cliente incluido com sucesso");
				return new ClientesDto(clienteIncluido);
			}
			return null;
		} catch (Exception e) {
			log.error("Erro ao incluir cliente", e);
			throw new GenericException("Erro ao incluir cliente.");
		}
	}

	@Override
	public ClientesDto alterar(ClientesDto clienteDtoRequest) {
		try {
			log.info("Alterando cliente");
			Clientes cliente = clienteRepository.findById(clienteDtoRequest.getId()).orElse(null);

			if (cliente == null) {
				log.info("Cliente não encontrado");
				throw new GenericException("Cliente não encontrado");
			}

			clienteDtoRequest.setId(cliente.getId());
			clienteDtoRequest.setDataAtualizacao(LocalDate.now());

			Clientes clienteAlterado = clienteRepository.save(clienteDtoRequest.toEntity());

			if (clienteAlterado != null) {
				log.info("Cliente alterado com sucesso");
				return new ClientesDto(clienteAlterado);
			}
			return null;
		} catch (Exception e) {
			log.error("Erro ao alterar cliente", e);
			throw new GenericException("Erro ao alterar cliente.");
		}
	}

	@Override
	public void excluir(Long id) {
		try {
			log.info("Excluindo cliente");
			Clientes cliente = clienteRepository.findById(id).orElse(null);

			if (cliente == null) {
				log.info("Cliente não encontrado");
				throw new GenericException("Cliente não encontrado");
			}

			clienteRepository.deleteById(id);
			log.info("Cliente excluido com sucesso");
		} catch (Exception e) {
			log.error("Erro ao excluir cliente", e);
			throw new GenericException("Erro ao excluir cliente.");
		}
	}

	@Override
	public ClientesDto findByCPF(String cpf) {
		try {
			log.info("Pesquisar clientes por CPF");
			Clientes cliente = clienteRepository.findByCPF(cpf);

			if (cliente == null) {
				log.info("Nenhum cliente encontrado");
				throw new GenericException("Nenhum cliente encontrado");
			}

			log.info("Clientes encontrados");
			return new ClientesDto(cliente);

		} catch (GenericException e) {
			log.error("Erro ao pesquisar todos os clientes", e);
			throw new GenericException("Erro ao pesquisar todos os clientes.");
		}
	}

}
