package br.com.fiap.lanchonete.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.fiap.lanchonete.dtos.ProdutosDto;
import br.com.fiap.lanchonete.entity.Produtos;
import br.com.fiap.lanchonete.exceptions.GenericException;
import br.com.fiap.lanchonete.repository.ProdutosRepository;
import br.com.fiap.lanchonete.service.ProdutosService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Qualifier("produtosPostgresService")
public class ProdutosServiceImpl implements ProdutosService{

	@Autowired
	private ProdutosRepository produtoRepository;

	@Override
	public List<ProdutosDto> findAll() {
        try {
            log.info("Pesquisar todos os produtos");
            List<Produtos> produtos = produtoRepository.findAll();

            if (produtos.isEmpty()) {
                log.info("Nenhum produto encontrado");
                throw new GenericException("Nenhum produto encontrado");
            }

            log.info("Produtos encontrados");
            return ProdutosDto.toDto(produtos);

        } catch (GenericException e) {
            log.error("Erro ao pesquisar todos os produtos", e);
            throw new GenericException("Erro ao pesquisar todos os produtos.");
        }
	}

	@Override
	public ProdutosDto incluir(ProdutosDto produtoDto) {
        try {
            log.info("Incluindo produto");

            produtoDto.setStatus(true);
            produtoDto.setDataCadastro(LocalDateTime.now());

            Produtos produtoIncluido = produtoRepository.save(produtoDto.toEntity());

            if (produtoIncluido != null) {
                log.info("Produto incluido com sucesso");
                return new ProdutosDto(produtoIncluido);
            }
            return null;
        } catch (Exception e) {
            log.error("Erro ao incluir produto", e);
            throw new GenericException("Erro ao incluir produto.");
        }
	}

	@Override
	public ProdutosDto alterar(ProdutosDto produtoDto) {
        try {
            log.info("Alterando produto");
            Produtos produto = produtoRepository.findById(produtoDto.getId()).orElse(null);

            if (produto == null) {
                log.info("Produto não encontrado");
                throw new GenericException("Produto não encontrado");
            }

            produtoDto.setId(produto.getId());
            produtoDto.setDataCadastro(LocalDateTime.now());

            Produtos produtoAlterado = produtoRepository.save(produtoDto.toEntity());

            if (produtoAlterado != null) {
                log.info("Produto alterado com sucesso");
                return new ProdutosDto(produtoAlterado);
            }
            return null;
        } catch (Exception e) {
            log.error("Erro ao alterar produto", e);
            throw new GenericException("Erro ao alterar produto.");
        }
	}

	@Override
	public void excluir(Long id) {
        try {
            log.info("Excluindo produto");
            Produtos produto = produtoRepository.findById(id).orElse(null);

            if (produto == null) {
                log.info("Produto não encontrado");
                throw new GenericException("Produto não encontrado");
            }

            produtoRepository.deleteById(id);
            log.info("Produto excluido com sucesso");
        } catch (Exception e) {
            log.error("Erro ao excluir produto", e);
            throw new GenericException("Erro ao excluir produto.");
        }
		
	}

	@Override
	public List<ProdutosDto> findByCategoria(String categoria) {
		try {
			log.info("Pesquisar produtos por CPF");
			List<Produtos> produtos = produtoRepository.findByCategoriasNome(categoria);

			 if (produtos.isEmpty()) {
				log.info("Nenhum produto encontrado");
				throw new GenericException("Nenhum produto encontrado");
			}

			log.info("Produtos encontrados");
			return ProdutosDto.toDto(produtos);

		} catch (GenericException e) {
			log.error("Erro ao pesquisar todos os produtos", e);
			throw new GenericException("Erro ao pesquisar todos os produtos.");
		}
	}
	
	
}
