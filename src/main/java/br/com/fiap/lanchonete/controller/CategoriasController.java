package br.com.fiap.lanchonete.controller;

import br.com.fiap.lanchonete.dominio.dtos.CategoriaDto;
import br.com.fiap.lanchonete.dominio.portas.interfaces.CategoriaServicePort;
import br.com.fiap.lanchonete.exceptions.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/categorias")
public class CategoriasController {

    private final CategoriaServicePort categoriaServicePort;

    public CategoriasController(CategoriaServicePort categoriaServicePort) {
        this.categoriaServicePort = categoriaServicePort;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDto>> listar() {
        List<CategoriaDto> resultado = categoriaServicePort.buscarTodos();

        if (resultado.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDto> pesquisar(@PathVariable("id") Long id) {
        CategoriaDto categoriaDto = categoriaServicePort.buscarPorId(id);

        if (Objects.isNull(categoriaDto)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(categoriaDto);
    }

    @PostMapping
    public ResponseEntity<Object> incluir(@Valid @RequestBody CategoriaDto categoriaDtoRequest) {
        try {
            CategoriaDto categoriaDto = categoriaServicePort.incluir(categoriaDtoRequest);

            if (Objects.isNull(categoriaDto)) {
                return ResponseEntity.badRequest().build();
            }

            return ResponseHandler.generateResponse("Categoria incluído com sucesso.", HttpStatus.CREATED, categoriaDto);
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
