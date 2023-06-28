package br.com.fiap.lanchonete.core.ports.services;

import java.util.List;

import br.com.fiap.lanchonete.application.apis.rest.dtos.PedidoDto;

public interface PedidoServicePort {

	List<PedidoDto> buscarTodos();

}
