package com.midia.sistema_notas.dto.gestion_academicaDTO;


import com.midia.sistema_notas.dto.catalogosDTO.*;
import com.midia.sistema_notas.entities.gestion_academica.Estudiante;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class EstudianteDTO {

    private Long idEstudiante;
    private TipoDocumentoDTO idTipoDocumento;
    private String numeroDocumento;
    private Date fechaNacimiento;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private TipoSangreDTO idTipoSangre;
    private CondicionFisicaDTO idTipoCondicionFisica;
    private CondicionPsicologicaDTO idTipoCondiconPsicologica;
    private EstadoEstudianteDTO idEstadoEstudiante;

    public EstudianteDTO() {
    }

    public EstudianteDTO(Estudiante estudiante) {
    }

    public EstudianteDTO toDTO(Estudiante estudiante) {
        return new EstudianteDTO(estudiante);
    }
}
