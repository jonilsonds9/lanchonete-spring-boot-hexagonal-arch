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

import br.com.fiap.lanchonete.dominio.dtos.PedidoDto;
import br.com.fiap.lanchonete.dominio.portas.interfaces.PedidoServicePort;
import br.com.fiap.lanchonete.exceptions.ResponseHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {

	@Autowired
	private PedidoServicePort pedidoServicePort;

	@GetMapping()
	public ResponseEntity<Object> listar() {
		log.info("Pesquisar todos os pedidos");
		try {
			List<PedidoDto> resultado = pedidoServicePort.buscarTodos();

			if (resultado.isEmpty()) {
				return ResponseHandler.generateResponse("Dado não encontrado!", HttpStatus.NO_CONTENT, resultado);
			}

			return ResponseHandler.generateResponse("Lista encontrada", HttpStatus.OK, resultado);
		} catch (RuntimeException e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);

		}
	}

}
