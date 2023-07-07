package br.com.fiap.lanchonete.domain.ports.services;

import br.com.fiap.lanchonete.domain.Pedido;

public interface CheckoutServicePort {

    boolean pagamento(Pedido pedido);
}
