package net.zip3rz.inventario_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "productos")
public class Producto {

    @Id
    private String id;
    
    private String nombre;
    
    private String descripcion;
    
    private int cantidad;
    
    private double precio;
    
}
