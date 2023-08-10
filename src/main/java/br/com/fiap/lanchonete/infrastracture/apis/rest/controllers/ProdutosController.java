package br.com.fiap.lanchonete.infrastracture.apis.rest.controllers;

import br.com.fiap.lanchonete.infrastracture.apis.rest.exceptions.NotFoundException;
import br.com.fiap.lanchonete.infrastracture.apis.rest.request.ProdutoRequestDto;
import br.com.fiap.lanchonete.infrastracture.apis.rest.response.ProdutoResponseDto;
import br.com.fiap.lanchonete.domain.Categoria;
import br.com.fiap.lanchonete.domain.Produto;
import br.com.fiap.lanchonete.domain.ports.services.ProdutoServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Produtos", description = "API de gerenciamento de produtos")
@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {

	private final ProdutoServicePort produtoServicePort;

	public ProdutosController(ProdutoServicePort produtoServicePort) {
		this.produtoServicePort = produtoServicePort;
	}

	@Operation(
			summary = "Lista todos os produtos",
			description = "Retorna uma lista de todos os produtos ou uma lista vazia se nenhum produto for encontrado")
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = { @Content(array = @ArraySchema(schema = @Schema(implementation = ProdutoResponseDto.class)), mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema", content = { @Content(schema = @Schema()) })
	})
	@GetMapping()
	public ResponseEntity<List<ProdutoResponseDto>> listar() {
		List<Produto> produtos = produtoServicePort.buscarTodos();
		List<ProdutoResponseDto> produtoResponseDtoList = produtos.stream().map(ProdutoResponseDto::new).toList();
		return ResponseEntity.ok(produtoResponseDtoList);
	}

	@Operation(
			summary = "Busca todos os produtos por categoria",
			description = "Retorna todos os protuso de uma determinada categoria")
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = ProdutoResponseDto.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = "Aa categoria fornecida não foi encontrada", content = { @Content(schema = @Schema()) })
	})
	@GetMapping("/categoria/{categoria}")
	public ResponseEntity<List<ProdutoResponseDto>> buscarPorCategoria(@PathVariable("categoria") String categoria) {
		List<Produto> produtos = produtoServicePort.buscarPorCategoria(Categoria.valueOf(categoria));
		List<ProdutoResponseDto> produtoResponseDtoList = produtos.stream().map(ProdutoResponseDto::new).toList();
		return ResponseEntity.ok(produtoResponseDtoList);
	}

	@Operation(
			summary = "Cadastra um novo produto",
			description = "Faz o cadastro de uma novo produto e retorna o produto em caso de sucesso")
	@ApiResponses({
			@ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = ProdutoResponseDto.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "400", description = "Dados inválidos ou incorretos", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema", content = { @Content(schema = @Schema()) })
	})
	@PostMapping
	public ResponseEntity<Object> incluir(@Valid @RequestBody ProdutoRequestDto produtoRequestDto) {
		Produto produto = produtoServicePort.cadastrar(produtoRequestDto.toProduto());
		return ResponseEntity.status(HttpStatus.CREATED).body(new ProdutoResponseDto(produto));
	}

	@Operation(
			summary = "Altera um produto existente",
			description = "Altera um produto já cadastrado no sistema")
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = ProdutoResponseDto.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "400", description = "Dados inválidos ou incorretos", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema", content = { @Content(schema = @Schema()) })
	})
	@PutMapping("/{id}")
	public ResponseEntity<Object> alterar(@PathVariable("id") Long id,
										  @Valid @RequestBody ProdutoRequestDto produtoRequestDto) {
		Produto produto = this.produtoServicePort.buscarPorId(id).orElseThrow(NotFoundException::new);
		produto.setNome(produtoRequestDto.nome());
		produto.setDescricao(produtoRequestDto.descricao());
		produto.setPreco(produtoRequestDto.preco());
		produto.setCategoria(produtoRequestDto.categoria());

		Produto produtoAlterado = produtoServicePort.alterar(produto);
		return ResponseEntity.ok(new ProdutoResponseDto(produtoAlterado));
	}

	@Operation(
			summary = "Exclui um produto existente",
			description = "Exclui um produto cadastrado no sistema")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Produto excluído com sucesso", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "404", description = "O Id do produto fornecido não foi encontrado", content = { @Content(schema = @Schema()) }),
	})
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
		produtoServicePort.excluir(id);
		return ResponseEntity.ok().build();
	}
}
