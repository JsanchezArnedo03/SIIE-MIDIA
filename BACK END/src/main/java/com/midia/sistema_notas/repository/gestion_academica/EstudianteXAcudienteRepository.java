package com.midia.sistema_notas.repository.gestion_academica;


import com.midia.sistema_notas.entities.gestion_academica.EstudianteXAcudiente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteXAcudienteRepository extends JpaRepository<EstudianteXAcudiente,Long> {


}
