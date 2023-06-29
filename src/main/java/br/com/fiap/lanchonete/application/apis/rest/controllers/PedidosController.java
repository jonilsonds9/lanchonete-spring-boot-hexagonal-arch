package br.com.fiap.lanchonete.application.apis.rest.controllers;

import br.com.fiap.lanchonete.application.apis.rest.request.PedidoDto;
import br.com.fiap.lanchonete.domain.Situacao;
import br.com.fiap.lanchonete.domain.ports.services.PedidoServicePort;
import br.com.fiap.lanchonete.infrastracture.exceptions.ResponseHandler;
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

	@PostMapping
	public ResponseEntity<Object> criar(@RequestBody PedidoDto pedidoDto) {
		// tenho pedido

		// chama API de pagamento

		// salvar pedido no banco?
	}

	@GetMapping
	public ResponseEntity<Object> listar(@RequestParam String situacao) {
		// Tentar transformar num valor do ENUM
		Situacao situacaoDoPedido = Situacao.valueOf(situacao);

		//query apenas pedidos da situacao na ordem

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
