package br.com.fiap.lanchonete.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.fiap.lanchonete.entity.Clientes;
import br.com.fiap.lanchonete.entity.Enderecos;
import br.com.fiap.lanchonete.entity.Logradouro;
import br.com.fiap.lanchonete.repository.LogradouroRepository;

public class HelperUtil {
	
    private HelperUtil() {
    }

    public static List<Logradouro> getLogradouro() {
    	
    	List<Logradouro> lista =  new ArrayList<>();
    	lista.add(new Logradouro("Aeroporto"));
    	lista.add(new Logradouro("Alameda"));
    	lista.add(new Logradouro("Área"));
    	lista.add(new Logradouro("Avenida"));
    	lista.add(new Logradouro("Campo"));
    	lista.add(new Logradouro("Chácara"));
    	lista.add(new Logradouro("Colônia"));
    	lista.add(new Logradouro("Condomínio"));
    	lista.add(new Logradouro("Conjunto"));
    	lista.add(new Logradouro("Distrito"));
    	lista.add(new Logradouro("Esplanada"));
    	lista.add(new Logradouro("Estação"));
    	lista.add(new Logradouro("Estrada"));
    	lista.add(new Logradouro("Favela"));
    	lista.add(new Logradouro("Fazenda"));
    	lista.add(new Logradouro("Feira"));
    	lista.add(new Logradouro("Jardim"));
    	lista.add(new Logradouro("Ladeira"));
    	lista.add(new Logradouro("Lago"));
    	lista.add(new Logradouro("Lagoa"));
    	lista.add(new Logradouro("Largo"));
    	lista.add(new Logradouro("Loteamento"));
    	lista.add(new Logradouro("Morro"));
    	lista.add(new Logradouro("Núcleo"));
    	lista.add(new Logradouro("Parque"));
    	lista.add(new Logradouro("Passarela"));
    	lista.add(new Logradouro("Pátio"));
    	lista.add(new Logradouro("Praça"));
    	lista.add(new Logradouro("Quadra"));
    	lista.add(new Logradouro("Recanto"));
    	lista.add(new Logradouro("Residencial"));
    	lista.add(new Logradouro("Rodovia"));
    	lista.add(new Logradouro("Rua"));
    	lista.add(new Logradouro("Setor"));
    	lista.add(new Logradouro("Sítio"));
    	lista.add(new Logradouro("Travessa"));
    	lista.add(new Logradouro("Trecho"));
    	lista.add(new Logradouro("Trevo"));
    	lista.add(new Logradouro("Vale"));
    	lista.add(new Logradouro("Vereda"));
    	lista.add(new Logradouro("Via"));
    	lista.add(new Logradouro("Viaduto"));
    	lista.add(new Logradouro("Viela"));
    	lista.add(new Logradouro("Vila"));
    	
    	return lista;
    }

	public static Clientes getCliente(Logradouro logradouro) {

		Enderecos enderecos = new Enderecos();		
		enderecos.setLogradouro(logradouro);
		enderecos.setEndereco("Av. Paulista");
		enderecos.setNumero("1012");
		enderecos.setComplemento("bloco 01");
		enderecos.setBairro("bela vista");
		enderecos.setCidade("São Paulo");
		enderecos.setEstado("São Paulo");
		enderecos.setCep("12345-678");
		
		Clientes clientes = new Clientes();
		clientes.setCPF("123.456.789-00");
		clientes.setNome("Teste Autom");
		clientes.setEmail("teste@gmail.com");
		clientes.setDataNascimento(LocalDate.now());
		clientes.setEndereco(enderecos);
		clientes.setDataCadastro(LocalDate.now());
		clientes.setAtivo(true);
		
		return clientes;
	}


}
