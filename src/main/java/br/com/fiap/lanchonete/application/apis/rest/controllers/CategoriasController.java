package br.com.fiap.lanchonete.application.apis.rest.controllers;

import br.com.fiap.lanchonete.application.apis.rest.request.CategoriaRequestDto;
import br.com.fiap.lanchonete.application.apis.rest.response.CategoriaResponseDto;
import br.com.fiap.lanchonete.domain.Categoria;
import br.com.fiap.lanchonete.domain.ports.services.CategoriaServicePort;
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

@Tag(name = "Categorias", description = "API de gerenciamento de categorias")
@RestController
@RequestMapping("/api/categorias")
public class CategoriasController {

    private final CategoriaServicePort categoriaServicePort;

    public CategoriasController(CategoriaServicePort categoriaServicePort) {
        this.categoriaServicePort = categoriaServicePort;
    }

    @Operation(
            summary = "Lista todas as categorias",
            description = "Retorna uma lista de todas as categorias")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(array = @ArraySchema(schema = @Schema(implementation = CategoriaResponseDto.class)), mediaType = "application/json") }),
    })
    @GetMapping
    public ResponseEntity<List<CategoriaResponseDto>> listar() {
        List<CategoriaResponseDto> categoriaResponseDtoList = Arrays.stream(Categoria.values())
                .map(Categoria::name)
                .map(CategoriaResponseDto::new).toList();
        return ResponseEntity.ok(categoriaResponseDtoList);
    }

//    @Operation(
//            summary = "Pesquisa por uma categoria pelo Id",
//            description = "Retorna uma categoria pelo Id")
//    @ApiResponses({
//            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = CategoriaResponseDto.class), mediaType = "application/json") }),
//            @ApiResponse(responseCode = "404", description = "O Id da categoria fornecido não foi encontrado", content = { @Content(schema = @Schema()) })
//    })
//    @GetMapping("/{id}")
//    public ResponseEntity<CategoriaResponseDto> pesquisar(@PathVariable("id") Long id) {
//        Optional<CategoriaResponseDto> optionalCategoriaDto = categoriaServicePort.buscarPorId(id);
//        return optionalCategoriaDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @Operation(
//            summary = "Cadastra uma nova categoria",
//            description = "Faz o cadastro de uma nova categoria e retorna a mesma em caso de sucesso")
//    @ApiResponses({
//            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = CategoriaResponseDto.class), mediaType = "application/json") }),
//            @ApiResponse(responseCode = "400", description = "Se algum dado não estiver correto", content = { @Content(schema = @Schema()) })
//    })
//    @PostMapping
//    public ResponseEntity<Object> adicionar(@Valid @RequestBody CategoriaRequestDto categoriaDtoRequest,
//                                            BindingResult result) {
//        if (result.hasErrors()) {
//            return ResponseEntity.badRequest().body(result.getAllErrors());
//        }
//
//        try {
//            CategoriaResponseDto categoriaResponseDto = categoriaServicePort.adicionar(categoriaDtoRequest);
//
//            if (Objects.isNull(categoriaResponseDto)) {
//                return ResponseEntity.badRequest().build();
//            }
//            return ResponseEntity.status(HttpStatus.CREATED).body(categoriaResponseDto);
//        } catch (RuntimeException e) {
//            return ResponseEntity.internalServerError().build();
//        }
//    }
//
//    @Operation(
//            summary = "Altera uma categoria existente",
//            description = "Altera uma categoria já cadastrada no sistema")
//    @ApiResponses({
//            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = CategoriaResponseDto.class), mediaType = "application/json") }),
//            @ApiResponse(responseCode = "400", description = "Se algum dado não estiver correto", content = { @Content(schema = @Schema()) })
//    })
//    @PutMapping("/{id}")
//    public ResponseEntity<Object> alterar(@PathVariable("id") Long id,
//                                          @Valid @RequestBody CategoriaRequestDto categoriaDtoRequest,
//                                          BindingResult result) {
//        if (result.hasErrors()) {
//            return ResponseEntity.badRequest().body(result.getAllErrors());
//        }
//
//        CategoriaResponseDto categoriaResponseDto = categoriaServicePort.alterar(id, categoriaDtoRequest);
//        return ResponseEntity.ok(categoriaResponseDto);
//    }
//
//    @Operation(
//            summary = "Exclui uma categoria existente",
//            description = "Exclui uma categoria cadastrada no sistema")
//    @ApiResponses({
//            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = CategoriaResponseDto.class), mediaType = "application/json") }),
//            @ApiResponse(responseCode = "404", description = "O Id da categoria fornecido não foi encontrado", content = { @Content(schema = @Schema()) })
//    })
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Object> excluir(@PathVariable("id") Long id) {
//        try {
//            categoriaServicePort.excluir(id);
//            return ResponseEntity.ok().build();
//        } catch (RuntimeException e) {
//            return ResponseEntity.internalServerError().build();
//        }
//    }
}
