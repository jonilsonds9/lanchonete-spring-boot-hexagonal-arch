package br.com.fiap.lanchonete.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.fiap.lanchonete.entity.Categorias;
import br.com.fiap.lanchonete.entity.Produtos;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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
	
	private Categorias categorias;
	

	public ProdutosDto(Produtos produtos) {
		this.id = produtos.getId();
		this.nome = produtos.getNome();
		this.descricao = produtos.getDescricao();
		this.preco = produtos.getPreco();
		this.dataCadastro = produtos.getDataCadastro();
		this.status = produtos.getStatus();
		this.categorias = produtos.getCategorias();
	}

	public static List<ProdutosDto> toDto(List<Produtos> produtos) {
		return produtos.stream().map(ProdutosDto::new).collect(Collectors.toList());
	}

	public Produtos toEntity() {
		Produtos produto = new Produtos();
		produto.setId(this.getId());
		produto.setNome(this.nome);
		produto.setDescricao(this.descricao);
		produto.setDataCadastro(this.dataCadastro);
		produto.setPreco(this.preco);
		produto.setStatus(this.status);
		produto.setCategorias(this.categorias);
        return produto;
	}

}
