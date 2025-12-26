package com.midia.sistema_notas.dto.catalogosDTO;

import com.midia.sistema_notas.entities.catalogos.CondicionPsicologica;
import com.midia.sistema_notas.entities.catalogos.EstadoAsignatura;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EstadoAsignaturaDTO {
    private Long idEstadoAsignatura;
    private String estadoAsignatura;

    public EstadoAsignaturaDTO() {
    }

    public EstadoAsignaturaDTO(EstadoAsignatura estadoAsignatura) {
    }

    public EstadoAsignaturaDTO toDTO(EstadoAsignatura estadoAsignatura) {
        return new EstadoAsignaturaDTO(estadoAsignatura);
    }
}
