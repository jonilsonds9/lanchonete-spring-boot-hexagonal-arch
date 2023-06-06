package br.com.fiap.lanchonete.config;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.lanchonete.entity.Categorias;
import br.com.fiap.lanchonete.entity.Clientes;
import br.com.fiap.lanchonete.entity.Logradouro;
import br.com.fiap.lanchonete.entity.Produtos;
import br.com.fiap.lanchonete.repository.CategoriasRepository;
import br.com.fiap.lanchonete.repository.ClientesRepository;
import br.com.fiap.lanchonete.repository.LogradouroRepository;
import br.com.fiap.lanchonete.repository.PedidosRepository;
import br.com.fiap.lanchonete.repository.ProdutosRepository;
import br.com.fiap.lanchonete.utils.HelperUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class DataInitializationConfig {

    @Autowired
    private LogradouroRepository logradouroRepository;
    
    @Autowired
    private ClientesRepository clientesRepository;
    
    @Autowired 
    private CategoriasRepository categoriasRepository;
    
    @Autowired
    private ProdutosRepository produtosRepository;
    
    
    @Autowired
    private PedidosRepository pedidosRepository;
    

    @Bean
    public CommandLineRunner dataInitialization() {
        return args -> {
        	
        	List<Logradouro> logradouros = logradouroRepository.findAll();
        	if (logradouros.size() == 0) {
        		log.info("******* Inserir logradouro na base de dados*******");
        		logradouroRepository.saveAll(HelperUtil.getLogradouro());
        	}
        	
        	Logradouro logradouro = logradouroRepository.findByNome("Rua");
        	Clientes cliente =  clientesRepository.save(HelperUtil.getCliente(logradouro));
        	        	
        	List<Categorias> categorias = categoriasRepository.findAll();
        	if (categorias.size() == 0) {
        		log.info("******* Inserir categoria na base de dados*******");
        		categoriasRepository.saveAll(HelperUtil.getCategoria());
        	}
        	      
        	List<Produtos> produtos = produtosRepository.findAll();
        	if (produtos.size() == 0) {
        		
        		log.info("******* Inserir produtos Batata frita na base de dados*******");
        		produtosRepository.saveAll(HelperUtil.getProdutoBatataFrita(categoriasRepository.findByNome("Batatas fritas")));
        		        		
        		log.info("******* Inserir produtos Bebidas na base de dados*******");
        		produtosRepository.saveAll(HelperUtil.getProdutoBebidas(categoriasRepository.findByNome("Bebidas")));
        	
        		log.info("******* Inserir produtos Hambúrgueres na base de dados*******");
        		produtosRepository.saveAll(HelperUtil.getProdutoHamurgueres(categoriasRepository.findByNome("Hambúrgueres")));

        		log.info("******* Inserir produtos Hot dogs na base de dados*******");
        		produtosRepository.saveAll(HelperUtil.getProdutoHotDogs(categoriasRepository.findByNome("Hot dogs")));

        		log.info("******* Inserir produtos Saladas na base de dados*******");
        		produtosRepository.saveAll(HelperUtil.getProdutoSaladas(categoriasRepository.findByNome("Saladas")));

        		log.info("******* Inserir produtos Saladas na base de dados*******");
        		produtosRepository.saveAll(HelperUtil.getProdutoSanduiches(categoriasRepository.findByNome("Sanduíches")));

        		log.info("******* Inserir produtos Sobremesas na base de dados*******");
        		produtosRepository.saveAll(HelperUtil.getProdutoSobremesa(categoriasRepository.findByNome("Sobremesas")));
       		
        	}
        	
        	List<Produtos> produto = produtosRepository.findByNome("Batatas Fritas Com Queijo E Bacon");
        	
        	pedidosRepository.save(HelperUtil.getPedido(cliente, produto));
        	
        };
    }
}