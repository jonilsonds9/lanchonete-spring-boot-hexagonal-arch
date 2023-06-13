package br.com.fiap.lanchonete.dominio.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.CategoriaEntity;
import lombok.Data;

@Data
public class ProdutosDto {

	private Long id;

	@NotBlank(message = "O nome é obrigatório")
	@Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
	@Pattern(regexp = "^[A-Za-z\\s]*$", message = "O nome não pode conter caracteres especiais")
	private String nome;

	@NotBlank(message = "A descrição é obrigatório")
	@Size(min = 3, max = 50, message = "A descrição deve ter entre 3 e 50 caracteres")
	@Pattern(regexp = "^[A-Za-z\\s]*$", message = "A descrição não pode conter caracteres especiais")
	private String descricao;

	@DecimalMin(value = "0.01", inclusive = true, message = "O valor deve ser maior que 0")
	@Digits(integer = 9, fraction = 2, message = "O valor deve ter no máximo 9 dígitos inteiros e 2 dígitos decimais")
	private BigDecimal preco;

	@Past(message = "A data e hora devem ser anteriores à data e hora atual")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime dataCadastro;

	private Boolean status;
	
	private CategoriaEntity categorias;

	public ProdutosDto(
			Long id,
			String nome,
			String descricao,
			BigDecimal preco,
			LocalDateTime dataCadastro,
			Boolean status, 
			CategoriaEntity categorias) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.dataCadastro = dataCadastro;
		this.status = status;
		this.categorias = categorias;
	}
	
	public ProdutosDto(Long id, 
			String nome, String descricao, LocalDateTime dataCadastro, 
			BigDecimal preco,
			Boolean status, CategoriaEntity categorias) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.dataCadastro = dataCadastro;
		this.status = status;
		this.categorias = categorias;
	}


	
}
