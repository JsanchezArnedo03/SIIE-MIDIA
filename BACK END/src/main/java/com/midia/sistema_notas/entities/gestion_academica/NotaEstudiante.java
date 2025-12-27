package com.midia.sistema_notas.entities.gestion_academica;

import com.midia.sistema_notas.entities.catalogos.Empresa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity @Table(name = "nota_estudiante")
@Data @NoArgsConstructor @AllArgsConstructor
public class NotaEstudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nota_estudiante")
    private Long idNotaEstudiante;
    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante idEstudiante;
    @ManyToOne
    @JoinColumn(name = "id_actividad")
    private ActividadEvaluativa idActividad;
    @Column(name = "nota")
    private BigDecimal nota;
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "fecha_registro")
    private Date fechaRegistro;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_empresa")
    private Empresa idEmpresa;
}
