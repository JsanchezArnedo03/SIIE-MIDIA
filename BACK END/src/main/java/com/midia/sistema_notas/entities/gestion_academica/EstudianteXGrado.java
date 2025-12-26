package com.midia.sistema_notas.entities.gestion_academica;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "estudiante_x_grado")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteXGrado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante_x_grado")
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER) // Muchos estudiantes pertenecen a un mismo grado
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_grado")
    private Grado grado;

}
