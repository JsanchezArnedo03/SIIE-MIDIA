package com.midia.sistema_notas.repository.catalogos;

import com.midia.sistema_notas.entities.catalogos.EstadoEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoEstudianteRepository extends JpaRepository<EstadoEstudiante,Long> {
}
