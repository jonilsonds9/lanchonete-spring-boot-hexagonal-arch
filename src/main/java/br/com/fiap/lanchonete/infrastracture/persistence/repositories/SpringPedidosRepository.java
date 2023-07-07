package br.com.fiap.lanchonete.infrastracture.persistence.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.fiap.lanchonete.infrastracture.persistence.entidades.PedidoEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository("pedidosPostgresRepository")
@Qualifier("pedidosPostgresRepository")
public interface SpringPedidosRepository extends JpaRepository<PedidoEntity, Long> {

    Optional<PedidoEntity> findByCodigoPedido(String codigo);

    default Integer countPedidoEntityByDataHoraCadastro(LocalDate localDate) {
        return countPedidoEntityByDataHoraCadastroBetween(localDate.atStartOfDay(),
                localDate.plusDays(1).atStartOfDay());
    }

    Integer countPedidoEntityByDataHoraCadastroBetween(LocalDateTime from, LocalDateTime to);

    //    Long countAllByDataHoraCadastroContaining(LocalDate localDate);
}
