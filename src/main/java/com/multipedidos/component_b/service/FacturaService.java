package com.multipedidos.component_b.service;

import com.multipedidos.component_b.model.Factura;
import com.multipedidos.component_b.repository.FacturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.multipedidos.multipedidos_common.OperacionesNegocio;

@Service
public class FacturaService {

    private final FacturaRepository repo;

    public FacturaService(FacturaRepository repo) {
        this.repo = repo;
    }

    public List<Factura> listar() {
        return repo.findAll();
    }

    public Optional<Factura> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public Factura guardar(Factura factura) {
        if (repo.existsByNumero(factura.getNumero())) {
            throw new RuntimeException("El número de factura ya existe");
        }

        double subtotal = factura.getMontoTotal();

        double totalConIva = OperacionesNegocio.calcularTotalConIVA(subtotal);

        if (subtotal > 1000) {
            totalConIva = OperacionesNegocio.aplicarDescuento(totalConIva, 10.0);
        }

        return repo.save(factura);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
