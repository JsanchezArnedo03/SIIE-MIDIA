package com.midia.sistema_notas.repository.gestion_academica;


import com.midia.sistema_notas.entities.gestion_academica.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula,Long> {

    @Query("SELECT m FROM Matricula m WHERE " +
            "m.grado = :grado AND m.estadoEstudiante = :estado")
    List<Matricula> findByGradoAndEstadoMatricula();

    @Query("SELECT m FROM Matricula m WHERE m.estudiante.idPersona = :idEstudiante AND m.empresa.idEmpresa = :idEmpresa")
    Matricula findByIdEstudianteAndIdEmpresa(@Param("idEstudiante") Long idEstudiante, @Param("idEmpresa") Long idEmpresa);
}
