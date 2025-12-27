package com.midia.sistema_notas.dto.gestion_academicaDTO;


import com.midia.sistema_notas.dto.catalogosDTO.*;
import com.midia.sistema_notas.entities.gestion_academica.Estudiante;
import com.midia.sistema_notas.entities.gestion_academica.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class EstudianteDTO {

    private Long idEstudiante;
    private Date fechaNacimiento;
    private TipoSangreDTO idTipoSangre;
    private CondicionFisicaDTO idTipoCondicionFisica;
    private CondicionPsicologicaDTO idTipoCondiconPsicologica;
    private EstadoEstudianteDTO idEstadoEstudiante;
    private Persona idPersona;
    public EstudianteDTO() {
    }

    public EstudianteDTO(Estudiante estudiante) {
    }

    public EstudianteDTO toDTO(Estudiante estudiante) {
        return new EstudianteDTO(estudiante);
    }
}
