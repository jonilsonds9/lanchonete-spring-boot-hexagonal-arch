package br.com.fiap.lanchonete.application.apis.rest.controllers;

import br.com.fiap.lanchonete.application.apis.rest.request.ClientesDto;
import br.com.fiap.lanchonete.domain.ports.services.ClienteServicePort;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Tag(name = "Clientes", description = "API de gerenciamento de clientes")
@Slf4j
@RestController
@RequestMapping("/api/clientes")
public class ClientesController {

    private final ClienteServicePort clienteServicePort;

    public ClientesController(ClienteServicePort clienteServicePort) {
        this.clienteServicePort = clienteServicePort;
    }

    @GetMapping()
    public ResponseEntity<Object> listar() {
        List<ClientesDto> resultado = clienteServicePort.buscarTodos();
        return ResponseEntity.ok(resultado);
    }

    @PostMapping("")
    public ResponseEntity<Object> incluir(@Valid @RequestBody ClientesDto clienteDtoRequest) {
        log.info("Incluir cliente");
        try {
            ClientesDto clienteDto = clienteServicePort.incluir(clienteDtoRequest);

            if (Objects.isNull(clienteDto)) {
                return ResponseHandler.generateResponse("Não foi possível incluir o cliente.", HttpStatus.BAD_REQUEST, clienteDto);
            }

            return ResponseHandler.generateResponse("Cliente incluído com sucesso.", HttpStatus.CREATED, clienteDto);
        } catch (RuntimeException e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PutMapping("")
    public ResponseEntity<Object> alterar(@Valid @RequestBody ClientesDto clienteDtoRequest) {
        log.info("Alterar cliente");
        try {
            ClientesDto clienteDto = clienteServicePort.alterar(clienteDtoRequest);

            if (Objects.isNull(clienteDto)) {
                return ResponseHandler.generateResponse("Não foi possível alterar o cliente.", HttpStatus.BAD_REQUEST, clienteDto);
            }

            return ResponseHandler.generateResponse("Cliente alterado com sucesso.", HttpStatus.OK, clienteDto);
        } catch (RuntimeException e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable("id") Long id) {
        log.info("Excluir cliente");
        try {
            clienteServicePort.excluir(id);
            return ResponseHandler.generateResponse("Cliente excluído com sucesso.", HttpStatus.OK, null);
        } catch (RuntimeException e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }


    @GetMapping("/{cpf}")
    public ResponseEntity<Object> pesquisar(@PathVariable("cpf") String cpf) {
        ClientesDto clienteDto = clienteServicePort.BuscarPorCPF(cpf);

        if (Objects.isNull(clienteDto)) {
            return new ResponseEntity<>("Cliente não encontrado.", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(clienteDto, HttpStatus.OK);
    }
}
