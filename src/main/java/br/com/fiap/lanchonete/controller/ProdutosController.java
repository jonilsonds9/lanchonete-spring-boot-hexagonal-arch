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

import br.com.fiap.lanchonete.dtos.ProdutosDto;
import br.com.fiap.lanchonete.exceptions.ResponseHandler;
import br.com.fiap.lanchonete.service.ProdutosService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {

	@Autowired
	private ProdutosService produtosService;

	@GetMapping()
	public ResponseEntity<Object> listar() {
		log.info("Pesquisar todos os produtos");
		try {
			List<ProdutosDto> resultado = produtosService.findAll();

			if (resultado.isEmpty()) {
				return ResponseHandler.generateResponse("Dado não encontrado!", HttpStatus.NO_CONTENT, resultado);
			}

			return ResponseHandler.generateResponse("Lista encontrada", HttpStatus.OK, resultado);
		} catch (RuntimeException e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);

		}
	}

	@PostMapping("")
	public ResponseEntity<Object> incluir(@Valid @RequestBody ProdutosDto produtosDtoRequest) {
		log.info("Incluir produtos");
		try {
			ProdutosDto produtosDto = produtosService.incluir(produtosDtoRequest);

			if (Objects.isNull(produtosDto)) {
				return ResponseHandler.generateResponse("Não foi possível incluir o produtos.", HttpStatus.BAD_REQUEST,
						produtosDto);
			}

			return ResponseHandler.generateResponse("Produto incluído com sucesso.", HttpStatus.CREATED, produtosDto);
		} catch (RuntimeException e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}

	@PutMapping("")
	public ResponseEntity<Object> alterar(@Valid @RequestBody ProdutosDto produtosDtoRequest) {
		log.info("Alterar produtos");
		try {
			ProdutosDto produtosDto = produtosService.alterar(produtosDtoRequest);

			if (Objects.isNull(produtosDto)) {
				return ResponseHandler.generateResponse("Não foi possível alterar o produtos.", HttpStatus.BAD_REQUEST,
						produtosDto);
			}

			return ResponseHandler.generateResponse("Produto alterado com sucesso.", HttpStatus.OK, produtosDto);
		} catch (RuntimeException e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> excluir(@PathVariable("id") Long id) {
		log.info("Excluir produtos");
		try {
			produtosService.excluir(id);
			return ResponseHandler.generateResponse("Produto excluído com sucesso.", HttpStatus.OK, null);
		} catch (RuntimeException e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}

	@GetMapping("/{categoria}")
	public ResponseEntity<Object> pesquisar(@PathVariable("categoria") String categoria) {
		List<ProdutosDto> produtosDto = produtosService.findByCategoria(categoria);

		if (produtosDto.isEmpty()) {
			return new ResponseEntity<>("Produto não encontrado.", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(produtosDto, HttpStatus.OK);
	}
}
