package br.com.fiap.lanchonete.infraestrutura.adaptadores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.CategoriaEntity;

@Repository
public interface SpringCategoriasRepository extends JpaRepository<CategoriaEntity, Long> {

	public CategoriaEntity findByNome(String string);

}
