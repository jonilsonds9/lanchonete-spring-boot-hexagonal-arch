package br.com.fiap.lanchonete.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.lanchonete.entity.Logradouro;

@Repository("logradouroPostgresRepository")
@Qualifier("logradouroPostgresRepository")
public interface LogradouroRepository extends JpaRepository<Logradouro, Long> {

	public Logradouro findByNome(String string);

}
