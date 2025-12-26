package com.midia.sistema_notas.repository.gestion_academica;

import com.midia.sistema_notas.entities.gestion_academica.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura,Long> {

}
