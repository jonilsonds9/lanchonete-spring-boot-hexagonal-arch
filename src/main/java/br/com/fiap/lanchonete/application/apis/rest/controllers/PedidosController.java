package br.com.fiap.lanchonete.application.apis.rest.controllers;

import br.com.fiap.lanchonete.application.apis.rest.dtos.PedidoDto;
import br.com.fiap.lanchonete.core.ports.services.PedidoServicePort;
import br.com.fiap.lanchonete.core.exceptions.ResponseHandler;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Pedidos", description = "API de gerenciamento de pedidos")
@Slf4j
@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {

    private final PedidoServicePort pedidoServicePort;

    public PedidosController(PedidoServicePort pedidoServicePort) {
        this.pedidoServicePort = pedidoServicePort;
    }

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
