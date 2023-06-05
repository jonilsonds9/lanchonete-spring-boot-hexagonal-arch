package br.com.fiap.lanchonete.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.lanchonete.entity.Enderecos;

@Repository("enderecoPostgresRepository")
@Qualifier("enderecoPostgresRepository")
public interface EnderecosRepository extends JpaRepository<Enderecos, Long> {

}
