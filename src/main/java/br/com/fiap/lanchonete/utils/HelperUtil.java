package br.com.fiap.lanchonete.utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.lanchonete.infrastracture.persistence.entidades.CategoriaEntity;
import br.com.fiap.lanchonete.infrastracture.persistence.entidades.ClienteEntity;
import br.com.fiap.lanchonete.infrastracture.persistence.entidades.EnderecoEntity;
import br.com.fiap.lanchonete.infrastracture.persistence.entidades.LogradouroEntity;
import br.com.fiap.lanchonete.infrastracture.persistence.entidades.PedidoEntity;
import br.com.fiap.lanchonete.infrastracture.persistence.entidades.ProdutoEntity;

public class HelperUtil {
	
    private HelperUtil() {
    }

    public static List<LogradouroEntity> getLogradouro() {
    	
    	List<LogradouroEntity> lista =  new ArrayList<>();
    	lista.add(new LogradouroEntity("Aeroporto"));
    	lista.add(new LogradouroEntity("Alameda"));
    	lista.add(new LogradouroEntity("Área"));
    	lista.add(new LogradouroEntity("Avenida"));
    	lista.add(new LogradouroEntity("Campo"));
    	lista.add(new LogradouroEntity("Chácara"));
    	lista.add(new LogradouroEntity("Colônia"));
    	lista.add(new LogradouroEntity("Condomínio"));
    	lista.add(new LogradouroEntity("Conjunto"));
    	lista.add(new LogradouroEntity("Distrito"));
    	lista.add(new LogradouroEntity("Esplanada"));
    	lista.add(new LogradouroEntity("Estação"));
    	lista.add(new LogradouroEntity("Estrada"));
    	lista.add(new LogradouroEntity("Favela"));
    	lista.add(new LogradouroEntity("Fazenda"));
    	lista.add(new LogradouroEntity("Feira"));
    	lista.add(new LogradouroEntity("Jardim"));
    	lista.add(new LogradouroEntity("Ladeira"));
    	lista.add(new LogradouroEntity("Lago"));
    	lista.add(new LogradouroEntity("Lagoa"));
    	lista.add(new LogradouroEntity("Largo"));
    	lista.add(new LogradouroEntity("Loteamento"));
    	lista.add(new LogradouroEntity("Morro"));
    	lista.add(new LogradouroEntity("Núcleo"));
    	lista.add(new LogradouroEntity("Parque"));
    	lista.add(new LogradouroEntity("Passarela"));
    	lista.add(new LogradouroEntity("Pátio"));
    	lista.add(new LogradouroEntity("Praça"));
    	lista.add(new LogradouroEntity("Quadra"));
    	lista.add(new LogradouroEntity("Recanto"));
    	lista.add(new LogradouroEntity("Residencial"));
    	lista.add(new LogradouroEntity("Rodovia"));
    	lista.add(new LogradouroEntity("Rua"));
    	lista.add(new LogradouroEntity("Setor"));
    	lista.add(new LogradouroEntity("Sítio"));
    	lista.add(new LogradouroEntity("Travessa"));
    	lista.add(new LogradouroEntity("Trecho"));
    	lista.add(new LogradouroEntity("Trevo"));
    	lista.add(new LogradouroEntity("Vale"));
    	lista.add(new LogradouroEntity("Vereda"));
    	lista.add(new LogradouroEntity("Via"));
    	lista.add(new LogradouroEntity("Viaduto"));
    	lista.add(new LogradouroEntity("Viela"));
    	lista.add(new LogradouroEntity("Vila"));
    	
    	return lista;
    }

	public static ClienteEntity getCliente(LogradouroEntity logradouro) {

		EnderecoEntity enderecos = new EnderecoEntity();		
		enderecos.setLogradouro(logradouro);
		enderecos.setEndereco("Av. Paulista");
		enderecos.setNumero("1012");
		enderecos.setComplemento("bloco 01");
		enderecos.setBairro("bela vista");
		enderecos.setCidade("São Paulo");
		enderecos.setEstado("São Paulo");
		enderecos.setCep("12345-678");
		
		ClienteEntity clientes = new ClienteEntity();
		clientes.setCPF("123.456.789-00");
		clientes.setNome("Teste Autom");
		clientes.setEmail("teste@gmail.com");
		clientes.setDataNascimento(LocalDate.now());
		clientes.setEndereco(enderecos);
		clientes.setDataCadastro(LocalDate.now());
		clientes.setAtivo(true);
		
		return clientes;
	}
	
	public static PedidoEntity getPedido(ClienteEntity cliente, List<ProdutoEntity> produto) {
		PedidoEntity pedidos = new PedidoEntity();
		
		pedidos.setCodigoPedido("YU10YU");
		pedidos.setClientes(cliente);
		pedidos.setEnderecoEntrega(cliente.getEndereco());
		pedidos.setValorTotal(BigDecimal.valueOf(150.99));
		pedidos.setProdutoSelecionados(produto);
		return pedidos;
	}

	public static List<CategoriaEntity> getCategoria() {
    	List<CategoriaEntity> lista =  new ArrayList<>();
    	lista.add(new CategoriaEntity("Batatas fritas")); 
    	lista.add(new CategoriaEntity("Bebidas")); 
    	lista.add(new CategoriaEntity("Hambúrgueres")); 
    	lista.add(new CategoriaEntity("Hot dogs")); 
    	lista.add(new CategoriaEntity("Saladas")); 
    	lista.add(new CategoriaEntity("Sanduíches")); 
    	lista.add(new CategoriaEntity("Sobremesas")); 
		return lista;
	}

	public static List<ProdutoEntity> getProdutoBatataFrita(CategoriaEntity categoria) {
		List<ProdutoEntity> lista =  new ArrayList<>();
		lista.add(new ProdutoEntity("Batatas Fritas Tradicionais", "Batatas Fritas Tradicionais", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new ProdutoEntity("Batatas Fritas Com Queijo E Bacon", "Batatas Fritas Com Queijo E Bacon", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new ProdutoEntity("Batatas Fritas Com Chili", "Batatas Fritas Com Chili", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new ProdutoEntity("Batatas Fritas Doces", "Batatas Fritas Doces", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));

		return lista;
	}

	
	public static List<ProdutoEntity> getProdutoHamurgueres(CategoriaEntity categoria) {
		List<ProdutoEntity> lista =  new ArrayList<>();
		lista.add(new ProdutoEntity("Cheeseburger", "Cheeseburger", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new ProdutoEntity("Hambúrguer Simples", "Hambúrguer Simples", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new ProdutoEntity("Hambúrguer Vegano", "Hambúrguer Vegano", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new ProdutoEntity("Hambúrguer De Frango", "Hambúrguer De Frango", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new ProdutoEntity("Hambúrguer De Peixe", "Hambúrguer De Peixe", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		return lista;
	}


	public static List<ProdutoEntity> getProdutoSanduiches(CategoriaEntity categoria) {
		List<ProdutoEntity> lista =  new ArrayList<>();
		lista.add(new ProdutoEntity("Sanduíche De Frango Grelhado", "Sanduíche De Frango Grelhado", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new ProdutoEntity("Club Sandwich", "Club Sandwich", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new ProdutoEntity("Sanduíche Blt (Bacon, Alface E Tomate)", "Sanduíche Blt (Bacon, Alface E Tomate)", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new ProdutoEntity("Sanduíche De Atum", "Sanduíche De Atum", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new ProdutoEntity("Sanduíche De Presunto E Queijo", "Sanduíche De Presunto E Queijo", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		return lista;
	}

	
	public static List<ProdutoEntity> getProdutoHotDogs(CategoriaEntity categoria) {
		List<ProdutoEntity> lista =  new ArrayList<>();
		lista.add(new ProdutoEntity("Hot Dog Tradicional", "Hot Dog Tradicional", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new ProdutoEntity("Cachorro-Quente Com Chili", "Cachorro-Quente Com Chili", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new ProdutoEntity("Hot Dog Vegetariano", "Hot Dog Vegetariano", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new ProdutoEntity("Hot Dog Com Queijo", "Hot Dog Com Queijo", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		return lista;
	}
	
	public static List<ProdutoEntity> getProdutoSaladas(CategoriaEntity categoria) {
		List<ProdutoEntity> lista =  new ArrayList<>();
		lista.add(new ProdutoEntity("Salada Caesar", "Salada Caesar", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new ProdutoEntity("Salada Grega", "Salada Grega", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new ProdutoEntity("Salada De Frango Grelhado", "Salada De Frango Grelhado", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new ProdutoEntity("Salada De Atum", "Salada De Atum", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new ProdutoEntity("Salada De Legumes", "Salada De Legumes", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		return lista;
	}
	
	public static List<ProdutoEntity> getProdutoBebidas(CategoriaEntity categoria) {
		List<ProdutoEntity> lista =  new ArrayList<>();
		lista.add(new ProdutoEntity("Refrigerantes (Coca-Cola, Pepsi, Sprite, Etc.)", "Refrigerantes (Coca-Cola, Pepsi, Sprite, Etc.)", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new ProdutoEntity("Sucos Naturais", "Sucos Naturais", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new ProdutoEntity("Milkshakes", "Milkshakes", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new ProdutoEntity("Chás Gelados", "Chás Gelados", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new ProdutoEntity("Café", "Café", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		return lista;
	}
	
	public static List<ProdutoEntity> getProdutoSobremesa(CategoriaEntity categoria) {
		List<ProdutoEntity> lista =  new ArrayList<>();
		lista.add(new ProdutoEntity("Sorvetes (Sundae, Casquinha, Milkshake)", "Sorvetes (Sundae, Casquinha, Milkshake)", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new ProdutoEntity("Tortas (Torta De Maçã, Torta De Limão)", "Tortas (Torta De Maçã, Torta De Limão)", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new ProdutoEntity("Brownies", "Brownies", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new ProdutoEntity("Cookies", "Cookies", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new ProdutoEntity("Cheesecake", "Cheesecake", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		return lista;
	}


}
