package br.com.fiap.lanchonete.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.lanchonete.entity.Logradouro;
import br.com.fiap.lanchonete.repository.ClientesRepository;
import br.com.fiap.lanchonete.repository.LogradouroRepository;
import br.com.fiap.lanchonete.utils.HelperUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class DataInitializationConfig {

    @Autowired
    private LogradouroRepository logradouroRepository;
    
    @Autowired
    private ClientesRepository clientesRepository;

    @Bean
    public CommandLineRunner dataInitialization() {
        return args -> {
        	
        	List<Logradouro> logradouros = logradouroRepository.findAll();
        	if (logradouros.size() == 0) {
        		log.info("******* Inserir logradouro na base de dados*******");
        		logradouroRepository.saveAll(HelperUtil.getLogradouro());
        	}
        	
        	Logradouro logradouro = logradouroRepository.findByNome("Rua");
        	clientesRepository.save(HelperUtil.getCliente(logradouro));
        	
        	
        };
    }
}