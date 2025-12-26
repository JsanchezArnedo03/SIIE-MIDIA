package com.midia.sistema_notas.dto.gestion_academicaDTO;

import com.midia.sistema_notas.entities.gestion_academica.Estudiante;
import com.midia.sistema_notas.entities.gestion_academica.NotaEstudiante;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotaEstudianteDTO {
    private Long idNotaEstudiante;
    private Estudiante idEstudiante;
    private ActividadEvaluativaDTO idActividad;
    private BigDecimal nota;
    private String observacion;
    private Date fechaRegistro;

    public NotaEstudianteDTO(NotaEstudiante notaEstudiante) {
    }

    public NotaEstudianteDTO toDTO(NotaEstudiante notaEstudiante) {
        return new NotaEstudianteDTO(notaEstudiante);
    }
}
