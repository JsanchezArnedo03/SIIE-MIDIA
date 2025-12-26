package com.midia.sistema_notas.entities.gestion_academica;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "asignatura_x_grado")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignaturaXGrado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignatura_x_grado")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_asignatura")
    private Asignatura asignatura;
    @ManyToOne
    @JoinColumn(name = "id_grado")
    private Grado grado;
}
