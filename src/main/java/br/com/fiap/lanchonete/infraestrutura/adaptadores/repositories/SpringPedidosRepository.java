package br.com.fiap.lanchonete.infraestrutura.adaptadores.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.PedidoEntity;

@Repository("pedidosPostgresRepository")
@Qualifier("pedidosPostgresRepository")
public interface SpringPedidosRepository extends JpaRepository<PedidoEntity, Long> {


}
