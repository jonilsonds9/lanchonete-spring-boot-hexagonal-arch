package br.com.fiap.lanchonete.controller;

import br.com.fiap.lanchonete.dominio.dtos.CategoriaDto;
import br.com.fiap.lanchonete.dominio.portas.interfaces.CategoriaServicePort;
import br.com.fiap.lanchonete.exceptions.ResponseHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/api/categorias")
public class CategoriasController {

    private final CategoriaServicePort categoriaServicePort;

    public CategoriasController(CategoriaServicePort categoriaServicePort) {
        this.categoriaServicePort = categoriaServicePort;
    }

    @GetMapping()
    public ResponseEntity<Object> listar() {
        log.info("Pesquisar todos os categorias");
        try {
            List<CategoriaDto> resultado = categoriaServicePort.buscarTodos();

            if (resultado.isEmpty()) {
                return ResponseHandler.generateResponse("Dado não encontrado!", HttpStatus.NO_CONTENT, resultado);
            }

            return ResponseHandler.generateResponse("Lista encontrada", HttpStatus.OK, resultado);
        } catch (RuntimeException e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);

        }
    }

    @PostMapping("")
    public ResponseEntity<Object> incluir(@Valid @RequestBody CategoriaDto categoriaDtoRequest) {
        log.info("Incluir categoria");
        try {
            CategoriaDto categoriaDto = categoriaServicePort.incluir(categoriaDtoRequest);

            if (Objects.isNull(categoriaDto)) {
                return ResponseHandler.generateResponse("Não foi possível incluir o categoria.", HttpStatus.BAD_REQUEST, categoriaDto);
            }

            return ResponseHandler.generateResponse("Categoria incluído com sucesso.", HttpStatus.CREATED, categoriaDto);
        } catch (RuntimeException e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PutMapping("")
    public ResponseEntity<Object> alterar(@Valid @RequestBody CategoriaDto categoriaDtoRequest) {
        log.info("Alterar categoria");
        try {
            CategoriaDto categoriaDto = categoriaServicePort.alterar(categoriaDtoRequest);

            if (Objects.isNull(categoriaDto)) {
                return ResponseHandler.generateResponse("Não foi possível alterar o categoria.", HttpStatus.BAD_REQUEST, categoriaDto);
            }

            return ResponseHandler.generateResponse("Categoria alterado com sucesso.", HttpStatus.OK, categoriaDto);
        } catch (RuntimeException e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable("id") Long id) {
        log.info("Excluir categoria");
        try {
            categoriaServicePort.excluir(id);
            return ResponseHandler.generateResponse("Categoria excluído com sucesso.", HttpStatus.OK, null);
        } catch (RuntimeException e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> pesquisar(@PathVariable("id") Long id) {
        CategoriaDto categoriaDto = categoriaServicePort.buscarPorId(id);

        if (Objects.isNull(categoriaDto)) {
            return new ResponseEntity<>("Categoria não encontrado.", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(categoriaDto, HttpStatus.OK);
    }
}
