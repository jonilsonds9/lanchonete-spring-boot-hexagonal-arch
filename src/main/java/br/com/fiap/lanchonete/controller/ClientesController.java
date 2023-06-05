package br.com.fiap.lanchonete.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.lanchonete.dtos.ClientesDto;
import br.com.fiap.lanchonete.exceptions.ResponseHandler;
import br.com.fiap.lanchonete.service.ClientesService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/clientes")
public class ClientesController {

	@Autowired
	private ClientesService clienteService;

	@GetMapping()
	public ResponseEntity<Object> listar() {
		log.info("Pesquisar todos os clientes");
		try {
			return clienteService.findAll();
		} catch (RuntimeException e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);

		}
	}

	@PostMapping("")
	public ResponseEntity<Object> incluir(@Valid @RequestBody ClientesDto clienteDtoRequest) {
		log.info("Incluir cliente");
		try {
			return clienteService.incluir(clienteDtoRequest);
		} catch (RuntimeException e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}

	@PutMapping("")
	public ResponseEntity<Object> alterar(@Valid @RequestBody ClientesDto clienteDtoRequest) {
		log.info("Alterar cliente");
		try {
			return clienteService.alterar(clienteDtoRequest);
		} catch (RuntimeException e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> excluir(@PathVariable("id") Long id) {
		log.info("Excluir cliente");
		try {
			return clienteService.excluir(id);
		} catch (RuntimeException e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}

	@GetMapping("/{cpf}")
	public ResponseEntity<Object> pesquisar(@PathVariable("cpf") String cpf) {
		return clienteService.findByCPF(cpf);
	}
}
