package br.com.fiap.lanchonete.application.apis.rest.controllers;

import br.com.fiap.lanchonete.application.apis.rest.request.ClienteRequestDto;
import br.com.fiap.lanchonete.application.apis.rest.response.CategoriaResponseDto;
import br.com.fiap.lanchonete.application.apis.rest.response.ClienteResponseDto;
import br.com.fiap.lanchonete.domain.Cliente;
import br.com.fiap.lanchonete.domain.ports.services.ClienteServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Tag(name = "Clientes", description = "API de gerenciamento de clientes")
@RestController
@RequestMapping("/api/clientes")
public class ClientesController {

    private final ClienteServicePort clienteServicePort;

    public ClientesController(ClienteServicePort clienteServicePort) {
        this.clienteServicePort = clienteServicePort;
    }

    @Operation(
            summary = "Listagem de clientes cadastrados",
            description = "Retorna a lista de clientes cadastrados no sistema")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(array = @ArraySchema(schema = @Schema(implementation = ClienteResponseDto.class)), mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", description = "Erro interno do sistema", content = { @Content(schema = @Schema()) })
    })
    @GetMapping
    public ResponseEntity<List<ClienteResponseDto>> listar() {
        List<Cliente> clienteList = clienteServicePort.buscarTodos();
        List<ClienteResponseDto> clienteResponseDtoList = clienteList.stream().map(ClienteResponseDto::new).toList();
        return ResponseEntity.ok(clienteResponseDtoList);
    }

    @Operation(
            summary = "Cadastro de cliente",
            description = "Realiza o cadastro de um novo cliente com os dados fornecidos e retorna o cliente cadastrado")
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = ClienteResponseDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos ou incorretos", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", description = "Erro interno do sistema", content = { @Content(schema = @Schema()) })
    })
    @PostMapping
    public ResponseEntity<Object> cadastrar(@Valid @RequestBody ClienteRequestDto clienteRequestDto,
                                            BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        try {
            Cliente cliente = clienteServicePort.cadastrar(clienteRequestDto.toCliente());
            return ResponseEntity.status(HttpStatus.CREATED).body(new ClienteResponseDto(cliente));
        } catch (RuntimeException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(
            summary = "Pesquisa um cliente pelo Id",
            description = "Retorna um cliente pelo Id, se for encontrado")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = CategoriaResponseDto.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "O Id do cliente fornecido não foi encontrado", content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/{cpf}")
    public ResponseEntity<ClienteResponseDto> buscarPorCpf(@PathVariable("cpf") String cpf) {
        Optional<Cliente> optionalCliente = clienteServicePort.buscarPorCpf(cpf);

        return optionalCliente.map(ClienteResponseDto::new)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
