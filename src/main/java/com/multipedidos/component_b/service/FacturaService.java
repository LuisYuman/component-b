package com.multipedidos.component_b.service;

import com.multipedidos.component_b.model.Factura;
import com.multipedidos.component_b.repository.FacturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return repo.save(factura);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
