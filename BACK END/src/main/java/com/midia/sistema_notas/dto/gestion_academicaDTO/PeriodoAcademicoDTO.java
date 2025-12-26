package com.midia.sistema_notas.dto.gestion_academicaDTO;

import com.midia.sistema_notas.entities.gestion_academica.PeriodoAcademico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeriodoAcademicoDTO {
    private Long id;
    private String nombre;
    private boolean estadoPeriodo;
    private Date fechaInicio;
    private Date fechaFin;

    public PeriodoAcademicoDTO(PeriodoAcademico periodoAcademico) {
    }

    public PeriodoAcademicoDTO toDTO(PeriodoAcademico periodoAcademico) {
        return new PeriodoAcademicoDTO(periodoAcademico);
    }
}
