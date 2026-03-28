package com.example.demo_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_service.model.entity.Proveedor;

@Repository

public interface ProveedorRepository  extends JpaRepository<Proveedor, Long>{

    Optional<Proveedor> findByNombreContainigIgnoreCase(String nombre);

    Optional<Proveedor> findByContacto(String contacto);

}


