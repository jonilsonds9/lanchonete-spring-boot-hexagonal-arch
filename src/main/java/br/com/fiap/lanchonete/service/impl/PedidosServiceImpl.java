package br.com.fiap.lanchonete.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.fiap.lanchonete.dtos.PedidosDto;
import br.com.fiap.lanchonete.entity.Pedidos;
import br.com.fiap.lanchonete.exceptions.GenericException;
import br.com.fiap.lanchonete.repository.PedidosRepository;
import br.com.fiap.lanchonete.service.PedidosService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Qualifier("pedidosPostgresService")
public class PedidosServiceImpl implements PedidosService{

	@Autowired
	private PedidosRepository pedidoRepository;
	
	@Override
	public List<PedidosDto> findAll() {
        try {
            log.info("Pesquisar todos os pedidos");
            List<Pedidos> pedidos = pedidoRepository.findAll();

            if (pedidos.isEmpty()) {
                log.info("Nenhum pedido encontrado");
                throw new GenericException("Nenhum pedido encontrado");
            }

            log.info("Pedidos encontrados");
            return PedidosDto.toDto(pedidos);

        } catch (GenericException e) {
            log.error("Erro ao pesquisar todos os pedidos", e);
            throw new GenericException("Erro ao pesquisar todos os pedidos.");
        }
	}

	@Override
	public PedidosDto incluir(PedidosDto pedidoDto) {
        try {
            log.info("Incluindo pedido");

            Pedidos pedidoIncluido = pedidoRepository.save(pedidoDto.toEntity());

            if (pedidoIncluido != null) {
                log.info("Pedido incluido com sucesso");
                return new PedidosDto(pedidoIncluido);
            }
            return null;
        } catch (Exception e) {
            log.error("Erro ao incluir pedido", e);
            throw new GenericException("Erro ao incluir pedido.");
        }
	}

	@Override
	public PedidosDto alterar(PedidosDto pedidoDto) {
        try {
            log.info("Alterando pedido");
            Pedidos pedido = pedidoRepository.findById(pedidoDto.getId()).orElse(null);

            if (pedido == null) {
                log.info("Pedido não encontrado");
                throw new GenericException("Pedido não encontrado");
            }

            Pedidos pedidoAlterado = pedidoRepository.save(pedido);

            if (pedidoAlterado != null) {
                log.info("Pedido alterado com sucesso");
                return new PedidosDto(pedidoAlterado);
            }
            return null;
        } catch (Exception e) {
            log.error("Erro ao alterar pedido", e);
            throw new GenericException("Erro ao alterar pedido.");
        }
	}

	@Override
	public void excluir(Long id) {
        try {
            log.info("Excluindo pedido");
            Pedidos pedido = pedidoRepository.findById(id).orElse(null);

            if (pedido == null) {
                log.info("Pedido não encontrado");
                throw new GenericException("Pedido não encontrado");
            }

            pedidoRepository.deleteById(id);
            log.info("Pedido excluido com sucesso");
        } catch (Exception e) {
            log.error("Erro ao excluir pedido", e);
            throw new GenericException("Erro ao excluir pedido.");
        }
		
	}
}
