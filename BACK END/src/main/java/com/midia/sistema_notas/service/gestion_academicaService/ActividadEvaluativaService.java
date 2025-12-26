package com.midia.sistema_notas.service.gestion_academicaService;

import com.midia.sistema_notas.entities.gestion_academica.ActividadEvaluativa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActividadEvaluativaService extends JpaRepository<ActividadEvaluativa,Long> {

}
