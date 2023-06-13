package br.com.fiap.lanchonete.dominio.portas.interfaces;

import java.util.List;

import br.com.fiap.lanchonete.dominio.dtos.PedidoDto;

public interface PedidoServicePort {

	public List<PedidoDto> buscarTodos();

}
