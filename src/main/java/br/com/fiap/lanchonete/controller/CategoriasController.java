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

import br.com.fiap.lanchonete.dtos.CategoriasDto;
import br.com.fiap.lanchonete.exceptions.ResponseHandler;
import br.com.fiap.lanchonete.service.CategoriasService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/categorias")
public class CategoriasController {

    @Autowired
    private CategoriasService categoriaService;

    @GetMapping()
    public ResponseEntity<Object> listar() {
        log.info("Pesquisar todos os categorias");
        try {
            List<CategoriasDto> resultado = categoriaService.findAll();

            if (resultado.isEmpty()) {
                return ResponseHandler.generateResponse("Dado não encontrado!", HttpStatus.NO_CONTENT, resultado);
            }

            return ResponseHandler.generateResponse("Lista encontrada", HttpStatus.OK, resultado);
        } catch (RuntimeException e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);

        }
    }

    @PostMapping("")
    public ResponseEntity<Object> incluir(@Valid @RequestBody CategoriasDto categoriaDtoRequest) {
        log.info("Incluir categoria");
        try {
            CategoriasDto categoriaDto = categoriaService.incluir(categoriaDtoRequest);

            if (Objects.isNull(categoriaDto)) {
                return ResponseHandler.generateResponse("Não foi possível incluir o categoria.", HttpStatus.BAD_REQUEST, categoriaDto);
            }

            return ResponseHandler.generateResponse("Categoria incluído com sucesso.", HttpStatus.CREATED, categoriaDto);
        } catch (RuntimeException e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PutMapping("")
    public ResponseEntity<Object> alterar(@Valid @RequestBody CategoriasDto categoriaDtoRequest) {
        log.info("Alterar categoria");
        try {
            CategoriasDto categoriaDto = categoriaService.alterar(categoriaDtoRequest);

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
            categoriaService.excluir(id);
            return ResponseHandler.generateResponse("Categoria excluído com sucesso.", HttpStatus.OK, null);
        } catch (RuntimeException e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> pesquisar(@PathVariable("id") Long id) {
        CategoriasDto categoriaDto = categoriaService.findById(id);

        if (Objects.isNull(categoriaDto)) {
            return new ResponseEntity<>("Categoria não encontrado.", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(categoriaDto, HttpStatus.OK);
    }
}
