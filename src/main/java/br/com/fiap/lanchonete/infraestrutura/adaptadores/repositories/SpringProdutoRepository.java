package br.com.fiap.lanchonete.infraestrutura.adaptadores.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.ProdutoEntity;

@Repository
public interface SpringProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

	public List<ProdutoEntity> findByCategoriasNome(String categoria);

	public List<ProdutoEntity> findByNome(String nome);

}
