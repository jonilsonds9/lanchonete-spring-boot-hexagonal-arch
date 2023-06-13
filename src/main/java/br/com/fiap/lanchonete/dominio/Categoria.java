package br.com.fiap.lanchonete.dominio;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.lanchonete.dominio.dtos.CategoriaDto;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.CategoriaEntity;
import lombok.Data;

@Data
public class Categoria {

    private Long id;    
    private String nome;
    
       
    public Categoria(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
	public static CategoriaDto toCategoriasDto(Long id, String nome) {
		return new CategoriaDto(id, nome);
	}

	public static Categoria toCategoria(Long id, String nome) {
		return new Categoria(id, nome);
	}

	
	public Categoria(CategoriaDto categoriaDto) {
		this.id = categoriaDto.getId();
		this.nome = categoriaDto.getNome();
	}

	public Categoria(CategoriaEntity categoriaEntity) {
		this.id = categoriaEntity.getId();
		this.nome = categoriaEntity.getNome();
	}

	public static CategoriaDto toCategoriaDto(Categoria categoria) {
		return new CategoriaDto(categoria.getId(), categoria.getNome());
	}

	public static List<Categoria> toCategorias(List<CategoriaEntity> categoriaEntities) {
		List<Categoria> categorias = new ArrayList<>();
		for (var categoria : categoriaEntities) {
			categorias.add(toCategoria(categoria.getId(), categoria.getNome()));
		}
		return categorias;
	}
}
