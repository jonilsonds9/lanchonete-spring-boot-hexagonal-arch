package br.com.fiap.lanchonete.infrastracture.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.lanchonete.application.apis.rest.services.CategoriaServiceImp;
import br.com.fiap.lanchonete.application.apis.rest.services.ClienteServiceImp;
import br.com.fiap.lanchonete.application.apis.rest.services.PedidoServiceImp;
import br.com.fiap.lanchonete.application.apis.rest.services.ProdutoServiceImp;
import br.com.fiap.lanchonete.domain.ports.services.CategoriaServicePort;
import br.com.fiap.lanchonete.domain.ports.services.ClienteServicePort;
import br.com.fiap.lanchonete.domain.ports.services.PedidoServicePort;
import br.com.fiap.lanchonete.domain.ports.services.ProdutoServicePort;
import br.com.fiap.lanchonete.domain.ports.repositories.CategoriaRepositoryPort;
import br.com.fiap.lanchonete.domain.ports.repositories.ClienteRepositoryPort;
import br.com.fiap.lanchonete.domain.ports.repositories.PedidoRepositoryPort;
import br.com.fiap.lanchonete.domain.ports.repositories.ProdutoRepositoryPort;

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
    
    @Bean
    CategoriaServicePort categoriaService(CategoriaRepositoryPort categoriaRepositoryPort) {
    	return new CategoriaServiceImp(categoriaRepositoryPort);
    }
    
    @Bean
    PedidoServicePort pedidoService(PedidoRepositoryPort pedidoRepositoryPort) {
    	return new PedidoServiceImp(pedidoRepositoryPort);
    }
}
