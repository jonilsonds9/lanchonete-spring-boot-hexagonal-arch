package br.com.fiap.lanchonete.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fiap.lanchonete.dtos.PedidosDto;

@Service
public interface PedidosService {

	public List<PedidosDto> findAll();

	public PedidosDto incluir(PedidosDto produtosDtoRequest);

	public PedidosDto alterar(PedidosDto produtosDtoRequest);

	public void excluir(Long id);

}
