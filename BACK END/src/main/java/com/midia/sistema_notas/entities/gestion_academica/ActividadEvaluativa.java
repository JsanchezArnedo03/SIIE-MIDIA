package com.midia.sistema_notas.entities.gestion_academica;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "actividad_evaluativa")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActividadEvaluativa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actividad")
    private Long idActividad;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "porcentaje")
    private double porcentaje;
    @ManyToOne
    @JoinColumn(name = "id_periodo")
    private PeriodoAcademico idPeriodo;
    @ManyToOne
    @JoinColumn(name = "id_asignatura")
    private Asignatura idAsignatura;
    @ManyToOne
    @JoinColumn(name = "id_tipo_actividad")
    private TipoActividad idTipoActividad;
    private Date fechaCreacion;
}
