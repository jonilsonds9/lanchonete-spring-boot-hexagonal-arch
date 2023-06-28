package br.com.fiap.lanchonete.infrastracture.databases.postgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.lanchonete.infrastracture.databases.postgres.entidades.ClienteEntity;

@Repository
public interface SpringClientesRepository extends JpaRepository<ClienteEntity, Long> {

	ClienteEntity findByCPF(String cpf);
}
