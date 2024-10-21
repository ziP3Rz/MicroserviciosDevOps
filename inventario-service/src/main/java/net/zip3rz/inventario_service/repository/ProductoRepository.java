package net.zip3rz.inventario_service.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import net.zip3rz.inventario_service.model.Producto;

public interface ProductoRepository extends MongoRepository<Producto, String> {
    Optional<Producto> findByNombre(String nombre);
}
