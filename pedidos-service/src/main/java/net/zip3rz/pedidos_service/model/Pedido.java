package net.zip3rz.pedidos_service.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String producto;
    
    private Integer cantidad;
    
    private LocalDateTime fechaPedido;
    
}
