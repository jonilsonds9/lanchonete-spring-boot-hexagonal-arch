package br.com.fiap.lanchonete.application.apis.rest.controllers;

import br.com.fiap.lanchonete.application.apis.rest.response.PedidoResponseDto;
import br.com.fiap.lanchonete.domain.Pedido;
import br.com.fiap.lanchonete.domain.ports.services.PedidoServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
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

	@Operation(
			summary = "Listagem de pedidos cadastrados",
			description = "Retorna a lista de pedidos cadastrados no sistema")
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = { @Content(array = @ArraySchema(schema = @Schema(implementation = PedidoResponseDto.class)), mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema", content = { @Content(schema = @Schema()) })
	})
	@GetMapping
	public ResponseEntity<List<PedidoResponseDto>> listar() {
		List<Pedido> pedidosList = pedidoServicePort.buscarTodos();
		List<PedidoResponseDto> pedidoResponseDtoList = pedidosList.stream().map(PedidoResponseDto::new).toList();
		return ResponseEntity.ok(pedidoResponseDtoList);
	}

//	@PostMapping
//	public ResponseEntity<Object> criar(@RequestBody PedidoDto pedidoDto) {
//		// tenho pedido
//
//		// chama API de pagamento
//
//		// salvar pedido no banco?
//		return null;
//	}

//	@GetMapping
//	public ResponseEntity<Object> listar(@RequestParam String situacao) {
//		// Tentar transformar num valor do ENUM
//		Situacao situacaoDoPedido = Situacao.valueOf(situacao);
//
//		//query apenas pedidos da situacao na ordem
//
//		try {
//			List<PedidoDto> resultado = pedidoServicePort.buscarTodos();
//
//			if (resultado.isEmpty()) {
//				return ResponseHandler.generateResponse("Dado não encontrado!", HttpStatus.NO_CONTENT, resultado);
//			}
//
//			return ResponseHandler.generateResponse("Lista encontrada", HttpStatus.OK, resultado);
//		} catch (RuntimeException e) {
//			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
//		}
//	}

}
