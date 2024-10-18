package service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.zip3rz.pedidos_service.model.Pedido;
import reposiroty.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
    public Pedido createPedido(String producto, Integer cantidad) {
        Pedido pedido = new Pedido();
        pedido.setProducto(producto);
        pedido.setCantidad(cantidad);
        pedido.setFechaPedido(LocalDateTime.now());
        return pedidoRepository.save(pedido);
    }
    
    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }
    
}

