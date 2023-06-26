package br.com.fiap.lanchonete.controller;

import br.com.fiap.lanchonete.dominio.dtos.CategoriaDto;
import br.com.fiap.lanchonete.dominio.dtos.categorias.CategoriaRequestDto;
import br.com.fiap.lanchonete.dominio.dtos.categorias.CategoriaResponseDto;
import br.com.fiap.lanchonete.dominio.portas.interfaces.CategoriaServicePort;
import br.com.fiap.lanchonete.exceptions.ResponseHandler;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.function.BinaryOperator;

@RestController
@RequestMapping("/api/categorias")
public class CategoriasController {

    private final CategoriaServicePort categoriaServicePort;

    public CategoriasController(CategoriaServicePort categoriaServicePort) {
        this.categoriaServicePort = categoriaServicePort;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDto>> listar() {
        List<CategoriaResponseDto> resultado = categoriaServicePort.buscarTodos();

        if (resultado.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponseDto> pesquisar(@PathVariable("id") Long id) {
        Optional<CategoriaResponseDto> optionalCategoriaDto = categoriaServicePort.buscarPorId(id);
        return optionalCategoriaDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Object> adicionar(@Valid @RequestBody CategoriaRequestDto categoriaDtoRequest, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        try {
            CategoriaResponseDto categoriaResponseDto = categoriaServicePort.adicionar(categoriaDtoRequest);

            if (Objects.isNull(categoriaResponseDto)) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(categoriaResponseDto);
        } catch (RuntimeException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping
    public ResponseEntity<Object> alterar(@Valid @RequestBody CategoriaDto categoriaDtoRequest) {
        try {
            CategoriaDto categoriaDto = categoriaServicePort.alterar(categoriaDtoRequest);

            if (Objects.isNull(categoriaDto)) {
                return ResponseEntity.badRequest().build();
            }

            return ResponseHandler.generateResponse("Categoria alterado com sucesso.", HttpStatus.OK, categoriaDto);
        } catch (RuntimeException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable("id") Long id) {
        try {
            categoriaServicePort.excluir(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
