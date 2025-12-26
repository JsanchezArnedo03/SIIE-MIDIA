package com.midia.sistema_notas.repository.gestion_academica;


import com.midia.sistema_notas.entities.gestion_academica.NotaEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface NotaEstudianteRepository extends JpaRepository<NotaEstudiante,Long> {

}
