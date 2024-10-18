package net.zip3rz.pedidos_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.zip3rz.pedidos_service.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
