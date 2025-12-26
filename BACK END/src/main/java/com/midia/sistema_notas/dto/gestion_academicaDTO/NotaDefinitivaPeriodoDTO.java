package com.midia.sistema_notas.dto.gestion_academicaDTO;

import com.midia.sistema_notas.entities.gestion_academica.Asignatura;
import com.midia.sistema_notas.entities.gestion_academica.Estudiante;
import com.midia.sistema_notas.entities.gestion_academica.NotaDefinitivaPeriodo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotaDefinitivaPeriodoDTO {
    private Long idDefinitiva;
    private Estudiante idEstudiante;
    private Asignatura idAsignatura;
    private PeriodoAcademicoDTO idPeriodo;
    private double promedioFinal;

    public NotaDefinitivaPeriodoDTO(NotaDefinitivaPeriodo notaDefinitivaPeriodo) {
    }

    public NotaDefinitivaPeriodoDTO toDTO(NotaDefinitivaPeriodo notaDefinitivaPeriodo) {
        return new NotaDefinitivaPeriodoDTO(notaDefinitivaPeriodo);
    }
}
