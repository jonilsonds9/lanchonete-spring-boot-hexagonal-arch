package br.com.fiap.lanchonete.infrastracture.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.lanchonete.infrastracture.persistence.entidades.ClienteEntity;

import java.util.Optional;

@Repository
public interface SpringClientesRepository extends JpaRepository<ClienteEntity, Long> {

	Optional<ClienteEntity> findByCpf(String cpf);
}
