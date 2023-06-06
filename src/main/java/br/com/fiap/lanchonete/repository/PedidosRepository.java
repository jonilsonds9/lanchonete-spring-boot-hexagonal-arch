package br.com.fiap.lanchonete.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.lanchonete.entity.Pedidos;

@Repository("pedidosPostgresRepository")
@Qualifier("pedidosPostgresRepository")
public interface PedidosRepository extends JpaRepository<Pedidos, Long> {


}
