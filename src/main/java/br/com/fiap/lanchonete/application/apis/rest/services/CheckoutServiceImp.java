package br.com.fiap.lanchonete.application.apis.rest.services;

import br.com.fiap.lanchonete.domain.Pedido;
import br.com.fiap.lanchonete.domain.ports.services.CheckoutServicePort;
import org.springframework.stereotype.Service;

@Service
public class CheckoutServiceImp implements CheckoutServicePort {

    public boolean pagamento(Pedido pedido) {
        return true;
    }
}
