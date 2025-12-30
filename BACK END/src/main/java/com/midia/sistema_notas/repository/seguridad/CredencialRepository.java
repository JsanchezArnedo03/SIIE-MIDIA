package com.midia.sistema_notas.repository.seguridad;

import com.midia.sistema_notas.entities.seguridad.Credencial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredencialRepository extends JpaRepository<Credencial, Long> {

    Optional<Credencial> findByUsername(String username);
}
