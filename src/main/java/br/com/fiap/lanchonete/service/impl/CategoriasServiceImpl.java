package br.com.fiap.lanchonete.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.fiap.lanchonete.dtos.CategoriasDto;
import br.com.fiap.lanchonete.entity.Categorias;
import br.com.fiap.lanchonete.exceptions.GenericException;
import br.com.fiap.lanchonete.repository.CategoriasRepository;
import br.com.fiap.lanchonete.service.CategoriasService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Qualifier("categoriaPostgresService")
public class CategoriasServiceImpl implements CategoriasService {
	
	@Autowired
	private CategoriasRepository categoriaRepository;

	@Override
	public List<CategoriasDto> findAll() {
        try {
            log.info("Pesquisar todos os categorias");
            List<Categorias> categorias = categoriaRepository.findAll();

            if (categorias.isEmpty()) {
                log.info("Nenhum categoria encontrado");
                throw new GenericException("Nenhum categoria encontrado");
            }

            log.info("Categorias encontrados");
            return CategoriasDto.toDto(categorias);

        } catch (GenericException e) {
            log.error("Erro ao pesquisar todos os categorias", e);
            throw new GenericException("Erro ao pesquisar todos os categorias.");
        }
	}

	@Override
	public CategoriasDto incluir(CategoriasDto categoriaDto) {
        try {
            log.info("Incluindo categoria");

            Categorias categoriaIncluido = categoriaRepository.save(categoriaDto.toEntity());

            if (categoriaIncluido != null) {
                log.info("Categoria incluido com sucesso");
                return new CategoriasDto(categoriaIncluido);
            }
            return null;
        } catch (Exception e) {
            log.error("Erro ao incluir categoria", e);
            throw new GenericException("Erro ao incluir categoria.");
        }
	}

	@Override
	public CategoriasDto alterar(CategoriasDto categoriaDto) {
        try {
            log.info("Alterando categoria");
            Categorias categoria = categoriaRepository.findById(categoriaDto.getId()).orElse(null);

            if (categoria == null) {
                log.info("Categoria não encontrado");
                throw new GenericException("Categoria não encontrado");
            }
            
            Categorias categoriaAlterado = categoriaRepository.save(categoriaDto.toEntity());

            if (categoriaAlterado != null) {
                log.info("Categoria alterado com sucesso");
                return new CategoriasDto(categoriaAlterado);
            }
            return null;
        } catch (Exception e) {
            log.error("Erro ao alterar categoria", e);
            throw new GenericException("Erro ao alterar categoria.");
        }
	}

	@Override
	public void excluir(Long id) {
        try {
            log.info("Excluindo categoria");
            Categorias categoria = categoriaRepository.findById(id).orElse(null);

            if (categoria == null) {
                log.info("Categoria não encontrado");
                throw new GenericException("Categoria não encontrado");
            }

            categoriaRepository.deleteById(id);
            log.info("Categoria excluido com sucesso");
        } catch (Exception e) {
            log.error("Erro ao excluir categoria", e);
            throw new GenericException("Erro ao excluir categoria.");
        }
		
	}

	@Override
	public CategoriasDto findById(Long id) {
		try {
			log.info("Pesquisar categorias por CPF");
			Optional<Categorias> optionalCategorias = categoriaRepository.findById(id);

			 if (optionalCategorias.isEmpty()) {
				log.info("Nenhum categoria encontrado");
				throw new GenericException("Nenhum categoria encontrado");
			}
			 
			log.info("Categorias encontrados");
			return new CategoriasDto(optionalCategorias.get());

		} catch (GenericException e) {
			log.error("Erro ao pesquisar todos os categorias", e);
			throw new GenericException("Erro ao pesquisar todos os categorias.");
		}
	}
}
