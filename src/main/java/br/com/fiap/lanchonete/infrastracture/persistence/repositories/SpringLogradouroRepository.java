package br.com.fiap.lanchonete.infrastracture.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.lanchonete.infrastracture.persistence.entidades.LogradouroEntity;

@Repository
public interface SpringLogradouroRepository extends JpaRepository<LogradouroEntity, Long> {

	LogradouroEntity findByNome(String string);

}
