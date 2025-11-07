package com.multipedidos.component_b.repository;

import com.multipedidos.component_b.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {

    boolean existsByNumero(String numeroFactura);
}
