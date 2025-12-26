package com.midia.sistema_notas.entities.gestion_academica;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "periodo_academico")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeriodoAcademico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_periodo")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "activo")
    private boolean estado_periodo;
    @Column(name = "fecha_inicio")
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    private Date fechaFin;
}
