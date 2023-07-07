package br.com.fiap.lanchonete.domain.ports.services;

import br.com.fiap.lanchonete.application.apis.rest.exceptions.PaymentException;
import br.com.fiap.lanchonete.domain.*;
import br.com.fiap.lanchonete.domain.ports.repositories.PedidoRepositoryPort;
import br.com.fiap.lanchonete.domain.ports.services.PedidoServicePort;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class PedidoServiceImp implements PedidoServicePort {

    private final PedidoRepositoryPort pedidoRepositoryPort;
    private final CheckoutServicePort checkoutServicePort;

    public PedidoServiceImp(PedidoRepositoryPort pedidoRepositoryPort, CheckoutServicePort checkoutServicePort) {
        this.pedidoRepositoryPort = pedidoRepositoryPort;
        this.checkoutServicePort = checkoutServicePort;
    }

	@Override
	public List<Pedido> buscarTodos() {
        return this.pedidoRepositoryPort.buscarTodos();
	}

    @Override
    public Optional<Pedido> buscarPorId(Long id) {
        return this.pedidoRepositoryPort.buscarPorId(id);
    }

    @Override
    public Optional<Pedido> buscarPorCodigoPedido(String codigo) {
        return this.pedidoRepositoryPort.buscarPorCodigoPedido(codigo);
    }

    @Override
    public Pedido criar(Cliente cliente, List<ItemPedido> itemPedidos) {
        Integer codigoPedido = this.pedidoRepositoryPort.ultimoPedido() + 1;

        Pedido pedido = new Pedido.PedidoBuilder()
                .codigoPedido(codigoPedido)
                .cliente(cliente)
                .itensPedido(itemPedidos)
                .build();

        boolean pago = this.checkoutServicePort.pagamento(pedido);
        if (!pago) {
            throw new PaymentException("Erro ao processar pagamento");
        }

        return this.pedidoRepositoryPort.salvar(pedido);
    }
}
