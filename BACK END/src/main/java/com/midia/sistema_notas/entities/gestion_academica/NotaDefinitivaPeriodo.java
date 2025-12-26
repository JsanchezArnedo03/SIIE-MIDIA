package com.midia.sistema_notas.entities.gestion_academica;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "nota_definitiva_periodo")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotaDefinitivaPeriodo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_definitiva")
    private Long idDefinitiva;
    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante idEstudiante;
    @ManyToOne
    @JoinColumn(name = "id_asignatura")
    private Asignatura idAsignatura;
    @ManyToOne
    @JoinColumn(name = "id_periodo")
    private PeriodoAcademico idPeriodo;
    @Column(name = "promedio_final")
    private double promedioFinal;
}
