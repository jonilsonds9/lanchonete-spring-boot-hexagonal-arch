package br.com.fiap.lanchonete.infraestrutura.adaptadores.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.ProdutoEntity;

@Repository
public interface SpringProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

	List<ProdutoEntity> findByCategoriasNome(String categoria);

	List<ProdutoEntity> findByNome(String nome);

}
