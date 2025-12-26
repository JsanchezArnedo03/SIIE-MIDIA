package com.midia.sistema_notas.dto.catalogosDTO;

import com.midia.sistema_notas.entities.catalogos.EstadoEstudiante;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class EstadoEstudianteDTO {

    /*1. aprobada 2. reprobada 3. suspendida 4. matriculada*/
    private Long idPersona;
    private String estadoPersona;

    public EstadoEstudianteDTO() {
    }

    public EstadoEstudianteDTO(EstadoEstudiante estadoEstudiante) {
    }

    public EstadoEstudianteDTO toDTO(EstadoEstudiante estadoEstudiante) {
        return new EstadoEstudianteDTO(estadoEstudiante);
    }
}
