package com.midia.sistema_notas.dto.gestion_academicaDTO;


import com.midia.sistema_notas.dto.catalogosDTO.*;
import com.midia.sistema_notas.entities.gestion_academica.Estudiante;
import com.midia.sistema_notas.entities.gestion_academica.Persona;
import com.midia.sistema_notas.enums.EstadoEstudiante;
import com.midia.sistema_notas.enums.TipoSangre;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class EstudianteDTO {

    private Long idEstudiante;
    private Date fechaNacimiento;
    private TipoSangre TipoSangre;
    private CondicionFisicaDTO idTipoCondicionFisica;
    private CondicionPsicologicaDTO idTipoCondiconPsicologica;
    private EstadoEstudiante idEstadoEstudiante;
    private Persona idPersona;
    public EstudianteDTO() {
    }

    public EstudianteDTO(Estudiante estudiante) {
    }

    public static EstudianteDTO toDTO(Estudiante estudiante) {
        return new EstudianteDTO(estudiante);
    }
}
