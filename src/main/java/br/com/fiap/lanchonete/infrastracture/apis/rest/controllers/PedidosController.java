package br.com.fiap.lanchonete.infrastracture.apis.rest.controllers;

import br.com.fiap.lanchonete.infrastracture.apis.rest.exceptions.NotFoundException;
import br.com.fiap.lanchonete.infrastracture.apis.rest.request.PedidoRequestDto;
import br.com.fiap.lanchonete.infrastracture.apis.rest.response.PedidoResponseDto;
import br.com.fiap.lanchonete.domain.*;
import br.com.fiap.lanchonete.domain.ports.services.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Tag(name = "Pedidos", description = "API de gerenciamento de pedidos")
@Slf4j
@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {

    private final PedidoServicePort pedidoServicePort;
	private final ClienteServicePort clienteServicePort;
	private final ProdutoServicePort produtoServicePort;


    public PedidosController(PedidoServicePort pedidoServicePort, ClienteServicePort clienteServicePort,
							 ProdutoServicePort produtoServicePort) {
        this.pedidoServicePort = pedidoServicePort;
		this.clienteServicePort = clienteServicePort;
		this.produtoServicePort = produtoServicePort;
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

	@Transactional
	@Operation(
			summary = "Cria um novo pedido",
			description = "Faz o cadastro de uma novo pedido e retorna o pedido em caso de sucesso")
	@ApiResponses({
			@ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = PedidoResponseDto.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "400", description = "Dados inválidos ou incorretos", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema", content = { @Content(schema = @Schema()) })
	})
	@PostMapping
	public ResponseEntity<Object> criar(@RequestBody @Valid PedidoRequestDto pedidoRequestDto) {
		List<ItemPedido> itemPedidos = pedidoRequestDto.itensPedido().stream()
				.map(itemPedidoRequestDto -> {
					if (itemPedidoRequestDto.produtoId() == null) throw new NotFoundException("Id do Produto não existe");

					Produto produto = this.produtoServicePort.buscarPorId(itemPedidoRequestDto.produtoId())
							.orElseThrow(NotFoundException::new);

					return new ItemPedido(produto, itemPedidoRequestDto.quantidade());
				}).toList();

		Cliente cliente = null;
		if (pedidoRequestDto.clienteInformouCpf()) {
			cliente = clienteServicePort.buscarPorCpf(pedidoRequestDto.clienteCpf())
					.orElseThrow(() -> new NotFoundException("Cliente não encontrado"));
		}

		Pedido novoPedido = this.pedidoServicePort.criar(cliente, itemPedidos);
		return ResponseEntity.status(HttpStatus.CREATED).body(new PedidoResponseDto(novoPedido));
	}
}
