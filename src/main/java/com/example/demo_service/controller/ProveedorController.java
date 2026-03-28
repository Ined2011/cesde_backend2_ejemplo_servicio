package com.example.demo_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo_service.model.entity.Proveedor;
import com.example.demo_service.service.ProveedorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    // GET /api/proveedores - Obtener todos los proveedores
    @GetMapping
    public List<Proveedor> getAllProveedores() {
        return proveedorService.getAllProveedor();
    }

    //  POST /api/proveedores - Crear un proveedor
    @PostMapping
    public Proveedor createProveedor(@RequestBody Proveedor proveedor) {
        return proveedorService.saveProveedor(proveedor);
    }

    //  GET /api/proveedores/buscar?nombre=... - Buscar por nombre
    @GetMapping("/buscar")
    public Optional<Proveedor> buscarPorNombre(@RequestParam String nombre) {
        return proveedorService.getProveedorByNombre(nombre);
    }

}