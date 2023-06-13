package br.com.fiap.lanchonete.infraestrutura.configuracao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.lanchonete.dominio.adaptadores.services.CategoriaServiceImp;
import br.com.fiap.lanchonete.dominio.adaptadores.services.ClienteServiceImp;
import br.com.fiap.lanchonete.dominio.adaptadores.services.PedidoServiceImp;
import br.com.fiap.lanchonete.dominio.adaptadores.services.ProdutoServiceImp;
import br.com.fiap.lanchonete.dominio.portas.interfaces.CategoriaServicePort;
import br.com.fiap.lanchonete.dominio.portas.interfaces.ClienteServicePort;
import br.com.fiap.lanchonete.dominio.portas.interfaces.PedidoServicePort;
import br.com.fiap.lanchonete.dominio.portas.interfaces.ProdutoServicePort;
import br.com.fiap.lanchonete.dominio.portas.repositories.CategoriaRepositoryPort;
import br.com.fiap.lanchonete.dominio.portas.repositories.ClienteRepositoryPort;
import br.com.fiap.lanchonete.dominio.portas.repositories.PedidoRepositoryPort;
import br.com.fiap.lanchonete.dominio.portas.repositories.ProdutoRepositoryPort;

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
