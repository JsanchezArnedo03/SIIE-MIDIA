package com.midia.sistema_notas.entities.gestion_academica;

import com.midia.sistema_notas.entities.catalogos.Empresa;
import com.midia.sistema_notas.enums.EstadoEstudiante;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Table(name = "matricula")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matricula")
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER) // Muchos estudiantes pertenecen a un mismo grado
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_grado")
    private Grado grado;
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_matricula")
    private EstadoEstudiante estadoEstudiante;
    @Column(name = "observaciones")
    private String observaciones;
    @CreationTimestamp
    @Column(name = "fecha_matricula")
    private Date fechaMatricula;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;
}
