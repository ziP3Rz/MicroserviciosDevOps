package net.zip3rz.pedidos_service.service;

import java.util.List;

import net.zip3rz.pedidos_service.model.Pedido;

public interface PedidoService {
	
	Pedido createPedido(String producto, Integer cantidad);
	
	List<Pedido> getAllPedidos();
	
}
