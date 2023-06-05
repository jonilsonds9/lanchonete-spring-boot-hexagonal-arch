package br.com.fiap.lanchonete.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.lanchonete.entity.Clientes;

@Repository("clientePostgresRepository")
@Qualifier("clientePostgresRepository")
public interface ClientesRepository extends JpaRepository<Clientes, Long> {

	public Clientes findByCPF(String cpf);
}
