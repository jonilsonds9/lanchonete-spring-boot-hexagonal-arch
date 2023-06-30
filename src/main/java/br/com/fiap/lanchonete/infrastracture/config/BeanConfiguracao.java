package br.com.fiap.lanchonete.infrastracture.config;

import br.com.fiap.lanchonete.application.apis.rest.services.*;
import br.com.fiap.lanchonete.domain.ports.repositories.*;
import br.com.fiap.lanchonete.domain.ports.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguracao {

    @Bean
    ProdutoServicePort produtoService(ProdutoRepositoryPort produtoRepositoryPort) {
        return new ProdutoServiceImp(produtoRepositoryPort);
    }

    @Bean
    ClienteServicePort clienteService(ClienteRepositoryPort clienteRepositoryPort) {
    	return new ClienteServiceImp(clienteRepositoryPort);
    }

//    @Bean
//    PedidoServicePort pedidoService(PedidoRepositoryPort pedidoRepositoryPort) {
//    	return new PedidoServiceImp(pedidoRepositoryPort);
//    }
}
