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
            List<ClientesDto> resultado = clienteService.findAll();

            if (resultado.isEmpty()) {
                return ResponseHandler.generateResponse("Dado não encontrado!", HttpStatus.NO_CONTENT, resultado);
            }

            return ResponseHandler.generateResponse("Lista encontrada", HttpStatus.OK, resultado);
        } catch (RuntimeException e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);

        }
    }

    @PostMapping("")
    public ResponseEntity<Object> incluir(@Valid @RequestBody ClientesDto clienteDtoRequest) {
        log.info("Incluir cliente");
        try {
            ClientesDto clienteDto = clienteService.incluir(clienteDtoRequest);

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
            ClientesDto clienteDto = clienteService.alterar(clienteDtoRequest);

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
            clienteService.excluir(id);
            return ResponseHandler.generateResponse("Cliente excluído com sucesso.", HttpStatus.OK, null);
        } catch (RuntimeException e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }


    @GetMapping("/{cpf}")
    public ResponseEntity<Object> pesquisar(@PathVariable("cpf") String cpf) {
        ClientesDto clienteDto = clienteService.findByCPF(cpf);

        if (Objects.isNull(clienteDto)) {
            return new ResponseEntity<>("Cliente não encontrado.", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(clienteDto, HttpStatus.OK);
    }
}
