package br.com.fiap.lanchonete.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import br.com.fiap.lanchonete.dtos.CategoriasDto;

@Service
public interface CategoriasService {

	public List<CategoriasDto> findAll();

	public CategoriasDto incluir(@Valid CategoriasDto categoriaDtoRequest);

	public CategoriasDto alterar(@Valid CategoriasDto categoriaDtoRequest);

	public void excluir(Long id);

	public CategoriasDto findById(Long id);

}
