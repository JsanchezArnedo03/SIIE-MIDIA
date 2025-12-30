package com.midia.sistema_notas.repository.gestion_academica;

import com.midia.sistema_notas.entities.seguridad.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
}
