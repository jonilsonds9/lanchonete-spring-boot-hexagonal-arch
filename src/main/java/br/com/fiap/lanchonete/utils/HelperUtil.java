package br.com.fiap.lanchonete.utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.fiap.lanchonete.entity.Categorias;
import br.com.fiap.lanchonete.entity.Clientes;
import br.com.fiap.lanchonete.entity.Enderecos;
import br.com.fiap.lanchonete.entity.Logradouro;
import br.com.fiap.lanchonete.entity.Pedidos;
import br.com.fiap.lanchonete.entity.Produtos;

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
	
	public static Pedidos getPedido(Clientes cliente, List<Produtos> produto) {
		Pedidos pedidos = new Pedidos();
		
		pedidos.setCodigoPedido("YU10YU");
		pedidos.setClientes(cliente);
		pedidos.setEnderecoEntrega(cliente.getEndereco());
		pedidos.setValorTotal(BigDecimal.valueOf(150.99));
		pedidos.setProdutoSelecionados(produto);
		return pedidos;
	}

	public static List<Categorias> getCategoria() {
    	List<Categorias> lista =  new ArrayList<>();
    	lista.add(new Categorias("Batatas fritas")); 
    	lista.add(new Categorias("Bebidas")); 
    	lista.add(new Categorias("Hambúrgueres")); 
    	lista.add(new Categorias("Hot dogs")); 
    	lista.add(new Categorias("Saladas")); 
    	lista.add(new Categorias("Sanduíches")); 
    	lista.add(new Categorias("Sobremesas")); 
		return lista;
	}

	public static List<Produtos> getProdutoBatataFrita(Categorias categoria) {
		List<Produtos> lista =  new ArrayList<>();
		lista.add(new Produtos("Batatas Fritas Tradicionais", "Batatas Fritas Tradicionais", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new Produtos("Batatas Fritas Com Queijo E Bacon", "Batatas Fritas Com Queijo E Bacon", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new Produtos("Batatas Fritas Com Chili", "Batatas Fritas Com Chili", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new Produtos("Batatas Fritas Doces", "Batatas Fritas Doces", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));

		return lista;
	}

	
	public static List<Produtos> getProdutoHamurgueres(Categorias categoria) {
		List<Produtos> lista =  new ArrayList<>();
		lista.add(new Produtos("Cheeseburger", "Cheeseburger", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new Produtos("Hambúrguer Simples", "Hambúrguer Simples", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new Produtos("Hambúrguer Vegano", "Hambúrguer Vegano", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new Produtos("Hambúrguer De Frango", "Hambúrguer De Frango", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new Produtos("Hambúrguer De Peixe", "Hambúrguer De Peixe", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		return lista;
	}


	public static List<Produtos> getProdutoSanduiches(Categorias categoria) {
		List<Produtos> lista =  new ArrayList<>();
		lista.add(new Produtos("Sanduíche De Frango Grelhado", "Sanduíche De Frango Grelhado", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new Produtos("Club Sandwich", "Club Sandwich", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new Produtos("Sanduíche Blt (Bacon, Alface E Tomate)", "Sanduíche Blt (Bacon, Alface E Tomate)", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new Produtos("Sanduíche De Atum", "Sanduíche De Atum", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new Produtos("Sanduíche De Presunto E Queijo", "Sanduíche De Presunto E Queijo", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		return lista;
	}

	
	public static List<Produtos> getProdutoHotDogs(Categorias categoria) {
		List<Produtos> lista =  new ArrayList<>();
		lista.add(new Produtos("Hot Dog Tradicional", "Hot Dog Tradicional", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new Produtos("Cachorro-Quente Com Chili", "Cachorro-Quente Com Chili", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new Produtos("Hot Dog Vegetariano", "Hot Dog Vegetariano", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new Produtos("Hot Dog Com Queijo", "Hot Dog Com Queijo", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		return lista;
	}
	
	public static List<Produtos> getProdutoSaladas(Categorias categoria) {
		List<Produtos> lista =  new ArrayList<>();
		lista.add(new Produtos("Salada Caesar", "Salada Caesar", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new Produtos("Salada Grega", "Salada Grega", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new Produtos("Salada De Frango Grelhado", "Salada De Frango Grelhado", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new Produtos("Salada De Atum", "Salada De Atum", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new Produtos("Salada De Legumes", "Salada De Legumes", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		return lista;
	}
	
	public static List<Produtos> getProdutoBebidas(Categorias categoria) {
		List<Produtos> lista =  new ArrayList<>();
		lista.add(new Produtos("Refrigerantes (Coca-Cola, Pepsi, Sprite, Etc.)", "Refrigerantes (Coca-Cola, Pepsi, Sprite, Etc.)", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new Produtos("Sucos Naturais", "Sucos Naturais", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new Produtos("Milkshakes", "Milkshakes", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new Produtos("Chás Gelados", "Chás Gelados", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new Produtos("Café", "Café", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		return lista;
	}
	
	public static List<Produtos> getProdutoSobremesa(Categorias categoria) {
		List<Produtos> lista =  new ArrayList<>();
		lista.add(new Produtos("Sorvetes (Sundae, Casquinha, Milkshake)", "Sorvetes (Sundae, Casquinha, Milkshake)", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new Produtos("Tortas (Torta De Maçã, Torta De Limão)", "Tortas (Torta De Maçã, Torta De Limão)", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new Produtos("Brownies", "Brownies", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new Produtos("Cookies", "Cookies", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		lista.add(new Produtos("Cheesecake", "Cheesecake", BigDecimal.valueOf(35.99) , LocalDateTime.now(), true, categoria));
		return lista;
	}


}
