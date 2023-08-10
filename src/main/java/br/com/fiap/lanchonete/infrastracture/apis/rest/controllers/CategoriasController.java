package br.com.fiap.lanchonete.infrastracture.apis.rest.controllers;

import br.com.fiap.lanchonete.infrastracture.apis.rest.response.CategoriaResponseDto;
import br.com.fiap.lanchonete.domain.Categoria;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Tag(name = "Categorias", description = "API de gerenciamento de categorias")
@RestController
@RequestMapping("/api/categorias")
public class CategoriasController {

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
}
