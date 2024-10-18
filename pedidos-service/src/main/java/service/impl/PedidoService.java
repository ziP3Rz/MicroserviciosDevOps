package service.impl;

import java.util.List;

import net.zip3rz.pedidos_service.model.Pedido;

public interface PedidoService {
	
	public Pedido createPedido(String producto, Integer cantidad);

	public List<Pedido> getAllPedidos();
	
}
