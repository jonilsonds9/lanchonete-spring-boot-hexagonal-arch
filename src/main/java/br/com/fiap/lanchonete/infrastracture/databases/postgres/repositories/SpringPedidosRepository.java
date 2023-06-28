package br.com.fiap.lanchonete.infrastracture.databases.postgres.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.lanchonete.infrastracture.databases.postgres.entidades.PedidoEntity;

@Repository("pedidosPostgresRepository")
@Qualifier("pedidosPostgresRepository")
public interface SpringPedidosRepository extends JpaRepository<PedidoEntity, Long> {


}
