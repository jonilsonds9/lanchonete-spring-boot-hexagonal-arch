package br.com.fiap.lanchonete.controller;

import java.util.List;
import java.util.Objects;

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

import br.com.fiap.lanchonete.dtos.PedidosDto;
import br.com.fiap.lanchonete.exceptions.ResponseHandler;
import br.com.fiap.lanchonete.service.PedidosService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {

	@Autowired
	private PedidosService pedidosService;

	@GetMapping()
	public ResponseEntity<Object> listar() {
		log.info("Pesquisar todos os pedidos");
		try {
			List<PedidosDto> resultado = pedidosService.findAll();

			if (resultado.isEmpty()) {
				return ResponseHandler.generateResponse("Dado não encontrado!", HttpStatus.NO_CONTENT, resultado);
			}

			return ResponseHandler.generateResponse("Lista encontrada", HttpStatus.OK, resultado);
		} catch (RuntimeException e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);

		}
	}

	@PostMapping("")
	public ResponseEntity<Object> incluir(@Valid @RequestBody PedidosDto pedidosDtoRequest) {
		log.info("Incluir pedidos");
		try {
			PedidosDto pedidosDto = pedidosService.incluir(pedidosDtoRequest);

			if (Objects.isNull(pedidosDto)) {
				return ResponseHandler.generateResponse("Não foi possível incluir o pedidos.", HttpStatus.BAD_REQUEST,
						pedidosDto);
			}

			return ResponseHandler.generateResponse("Pedido incluído com sucesso.", HttpStatus.CREATED, pedidosDto);
		} catch (RuntimeException e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}

	@PutMapping("")
	public ResponseEntity<Object> alterar(@Valid @RequestBody PedidosDto pedidosDtoRequest) {
		log.info("Alterar pedidos");
		try {
			PedidosDto pedidosDto = pedidosService.alterar(pedidosDtoRequest);

			if (Objects.isNull(pedidosDto)) {
				return ResponseHandler.generateResponse("Não foi possível alterar o pedidos.", HttpStatus.BAD_REQUEST,
						pedidosDto);
			}

			return ResponseHandler.generateResponse("Pedido alterado com sucesso.", HttpStatus.OK, pedidosDto);
		} catch (RuntimeException e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> excluir(@PathVariable("id") Long id) {
		log.info("Excluir pedidos");
		try {
			pedidosService.excluir(id);
			return ResponseHandler.generateResponse("Pedido excluído com sucesso.", HttpStatus.OK, null);
		} catch (RuntimeException e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}
}
