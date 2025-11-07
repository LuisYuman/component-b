package com.multipedidos.component_b.service;

import com.multipedidos.component_b.model.Proveedor;
import com.multipedidos.component_b.repository.ProveedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {

    private final ProveedorRepository repo;

    public ProveedorService(ProveedorRepository repo) {
        this.repo = repo;
    }

    public List<Proveedor> listar() {
        return repo.findAll();
    }

    public Optional<Proveedor> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public Proveedor guardar(Proveedor proveedor) {
        if (repo.existsByCorreo(proveedor.getCorreo())) {
            throw new RuntimeException("El correo ya está registrado");
        }
        return repo.save(proveedor);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
