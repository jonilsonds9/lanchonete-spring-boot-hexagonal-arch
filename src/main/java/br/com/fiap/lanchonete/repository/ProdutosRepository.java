package br.com.fiap.lanchonete.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.lanchonete.entity.Produtos;

@Repository("produtosPostgresRepository")
@Qualifier("produtosPostgresRepository")
public interface ProdutosRepository extends JpaRepository<Produtos, Long> {

	public List<Produtos> findByCategoriasNome(String categoria);

	public List<Produtos> findByNome(String nome);

}
