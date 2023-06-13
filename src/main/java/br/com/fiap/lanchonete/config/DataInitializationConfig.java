package br.com.fiap.lanchonete.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.CategoriaEntity;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.ClienteEntity;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.LogradouroEntity;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.ProdutoEntity;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.repositories.SpringCategoriasRepository;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.repositories.SpringClientesRepository;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.repositories.SpringLogradouroRepository;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.repositories.SpringPedidosRepository;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.repositories.SpringProdutoRepository;
import br.com.fiap.lanchonete.utils.HelperUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class DataInitializationConfig {

    @Autowired
    private SpringLogradouroRepository logradouroRepository;
    
    @Autowired
    private SpringClientesRepository clientesRepository;
    
    @Autowired 
    private SpringCategoriasRepository categoriasRepository;
    
    @Autowired
    private SpringProdutoRepository produtosRepository;

    @Autowired
    private SpringPedidosRepository pedidosRepository;
    

    @Bean
    public CommandLineRunner dataInitialization() {
        return args -> {
        	
        	List<LogradouroEntity> logradouros = logradouroRepository.findAll();
        	if (logradouros.size() == 0) {
        		log.info("******* Inserir logradouro na base de dados*******");
        		logradouroRepository.saveAll(HelperUtil.getLogradouro());
        	}
        	
        	LogradouroEntity logradouro = logradouroRepository.findByNome("Rua");
        	ClienteEntity cliente =  clientesRepository.save(HelperUtil.getCliente(logradouro));
        	        	
        	List<CategoriaEntity> categorias = categoriasRepository.findAll();
        	if (categorias.size() == 0) {
        		log.info("******* Inserir categoria na base de dados*******");
        		categoriasRepository.saveAll(HelperUtil.getCategoria());
        	}
        	      
        	List<ProdutoEntity> produtos = produtosRepository.findAll();
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
        	
        	List<ProdutoEntity> produto = produtosRepository.findByNome("Batatas Fritas Com Queijo E Bacon");
        	
        	pedidosRepository.save(HelperUtil.getPedido(cliente, produto));
        	
        };
    }
}