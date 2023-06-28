package br.com.fiap.lanchonete.infrastracture.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.lanchonete.infrastracture.persistence.entidades.CategoriaEntity;

@Repository
public interface SpringCategoriasRepository extends JpaRepository<CategoriaEntity, Long> {

	CategoriaEntity findByNome(String string);

}
