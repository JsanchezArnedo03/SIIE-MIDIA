package com.midia.sistema_notas.dto.gestion_academicaDTO;

import com.midia.sistema_notas.entities.gestion_academica.ActividadEvaluativa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActividadEvaluativaDTO {
    private Long idActividad;
    private String nombre;
    private double porcentaje;
    private Long idPeriodo;
    private Long idAsignatura;
    private Long idTipoActividad;
    private Date fechaCreacion;

    public ActividadEvaluativaDTO (ActividadEvaluativa actividadEvaluativa){}

    public ActividadEvaluativaDTO toDTO(ActividadEvaluativa actividadEvaluativa){
        return new ActividadEvaluativaDTO(actividadEvaluativa);
    }
}
