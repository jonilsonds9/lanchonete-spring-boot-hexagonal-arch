package br.com.fiap.lanchonete.application.apis.rest.controllers;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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

import br.com.fiap.lanchonete.application.apis.rest.request.ProdutosDto;
import br.com.fiap.lanchonete.domain.ports.services.ProdutoServicePort;
import br.com.fiap.lanchonete.infrastracture.exceptions.ResponseHandler;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "Produtos", description = "API de gerenciamento de produtos")
@Slf4j
@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {

	@Autowired
	private ProdutoServicePort produtoServicePort;

	@Operation(
			summary = "Lista todos os produtos",
			description = "Retorna uma lista de todos os produtos ou uma lista vazia se nenhum produto for encontrado")
	@GetMapping()
	public ResponseEntity<Object> listar() {
		log.info("Pesquisar todos os produtos");
		try {
			List<ProdutosDto> resultado = produtoServicePort.findAll();

			if (resultado.isEmpty()) {
				return ResponseHandler.generateResponse("Dado não encontrado!", HttpStatus.NO_CONTENT, resultado);
			}

			return ResponseHandler.generateResponse("Lista encontrada", HttpStatus.OK, resultado);
		} catch (RuntimeException e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);

		}
	}

	@Operation(
			summary = "Cadastra um novo produto",
			description = "Faz o cadastro de uma novo produto e retorna o produto em caso de sucesso")
	@PostMapping("")
	public ResponseEntity<Object> incluir(@Valid @RequestBody ProdutosDto produtosDtoRequest) {
		log.info("Incluir produtos");
		try {
			ProdutosDto produtosDto = produtoServicePort.incluir(produtosDtoRequest);

			if (Objects.isNull(produtosDto)) {
				return ResponseHandler.generateResponse("Não foi possível incluir o produtos.", HttpStatus.BAD_REQUEST,
						produtosDto);
			}

			return ResponseHandler.generateResponse("Produto incluído com sucesso.", HttpStatus.CREATED, produtosDto);
		} catch (RuntimeException e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}

	@Operation(
			summary = "Altera um produto existente",
			description = "Altera um produto já cadastrado no sistema")
	@PutMapping("")
	public ResponseEntity<Object> alterar(@Valid @RequestBody ProdutosDto produtosDtoRequest) {
		log.info("Alterar produtos");
		try {
			ProdutosDto produtosDto = produtoServicePort.alterar(produtosDtoRequest);

			if (Objects.isNull(produtosDto)) {
				return ResponseHandler.generateResponse("Não foi possível alterar o produtos.", HttpStatus.BAD_REQUEST,
						produtosDto);
			}

			return ResponseHandler.generateResponse("Produto alterado com sucesso.", HttpStatus.OK, produtosDto);
		} catch (RuntimeException e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}

	@Operation(
			summary = "Exclui um produto existente",
			description = "Exclui um produto cadastrado no sistema")
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> excluir(@PathVariable("id") Long id) {
		log.info("Excluir produtos");
		try {
			produtoServicePort.excluir(id);
			return ResponseHandler.generateResponse("Produto excluído com sucesso.", HttpStatus.OK, null);
		} catch (RuntimeException e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}

	@Operation(
			summary = "Pesquisa por um produto pelo Id",
			description = "Retorna um produto pelo Id")
	@GetMapping("/{categoria}")
	public ResponseEntity<Object> pesquisar(@PathVariable("categoria") String categoria) {
		List<ProdutosDto> produtosDto = produtoServicePort.buscarPorCategoria(categoria);

		if (produtosDto.isEmpty()) {
			return new ResponseEntity<>("Produto não encontrado.", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(produtosDto, HttpStatus.OK);
	}
}
