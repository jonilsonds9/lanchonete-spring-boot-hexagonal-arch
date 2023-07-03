package br.com.fiap.lanchonete.infrastracture.persistence.repositories;

import java.util.List;

import br.com.fiap.lanchonete.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.lanchonete.infrastracture.persistence.entidades.ProdutoEntity;

@Repository
public interface SpringProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

	List<ProdutoEntity> findByCategoria(Categoria categoria);
}
