package br.com.fiap.lanchonete.infraestrutura.adaptadores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.EnderecoEntity;

@Repository
public interface SpringEnderecosRepository extends JpaRepository<EnderecoEntity, Long> {

}
