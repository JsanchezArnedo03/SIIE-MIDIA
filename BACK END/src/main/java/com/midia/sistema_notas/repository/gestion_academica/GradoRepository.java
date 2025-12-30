package com.midia.sistema_notas.repository.gestion_academica;


import com.midia.sistema_notas.entities.gestion_academica.Grado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradoRepository extends JpaRepository<Grado,Long> {
    Grado findFirstByIdGradoGreaterThanOrderByIdGradoAsc(Long id);
}
