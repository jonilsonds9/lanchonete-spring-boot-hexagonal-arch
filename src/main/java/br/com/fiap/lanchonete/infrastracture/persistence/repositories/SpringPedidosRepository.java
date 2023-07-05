package br.com.fiap.lanchonete.infrastracture.persistence.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.lanchonete.infrastracture.persistence.entidades.PedidoEntity;

import java.util.Optional;

@Repository("pedidosPostgresRepository")
@Qualifier("pedidosPostgresRepository")
public interface SpringPedidosRepository extends JpaRepository<PedidoEntity, Long> {

    Optional<PedidoEntity> findByCodigoPedido(String codigo);
}
