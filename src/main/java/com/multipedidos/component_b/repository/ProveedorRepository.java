package com.multipedidos.component_b.repository;

import com.multipedidos.component_b.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
    boolean existsByCorreo(String correo);
}
