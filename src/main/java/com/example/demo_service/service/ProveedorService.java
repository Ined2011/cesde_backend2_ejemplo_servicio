package com.example.demo_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_service.model.entity.Proveedor;
import com.example.demo_service.repository.ProveedorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    // Create
    public Proveedor saveProveedor(Proveedor proveedor) {
        //  Validación simple directa
        if (proveedor.getTelefono().length() != 10) {
            throw new RuntimeException("El teléfono debe tener exactamente 10 dígitos");
        }
        return proveedorRepository.save(proveedor);
    }

    // Read - Get all proveedor
    public List<Proveedor> getAllProveedor() {
        return proveedorRepository.findAll();
    }

    // Read - Get proveedor by ID
    public Optional<Proveedor> getProveedorById(Long id) {
        return proveedorRepository.findById(id);
    }

    // Read - Get proveedor by contacto
    public Optional<Proveedor> getProveedorByNombre(String contacto) {
        return proveedorRepository.findByContacto(contacto);
    }

    // Update
    public Proveedor updateProveedor(Long id, Proveedor proveedorDetails) {
        Proveedor proveedor = proveedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor not found with id: " + id));

        //  Validación simple directa
        if (proveedorDetails.getTelefono().length() != 10) {
            throw new RuntimeException("El teléfono debe tener exactamente 10 dígitos");
        }

        proveedor.setNombre(proveedorDetails.getNombre());
        proveedor.setContacto(proveedorDetails.getContacto());
        proveedor.setTelefono(proveedorDetails.getTelefono());

        return proveedorRepository.save(proveedor);
    }

    // Delete
    public void deleteProveedor(Long id) {
        Proveedor proveedor = proveedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor not found with id: " + id));
        proveedorRepository.delete(proveedor);
    }
}