package com.midia.sistema_notas.entities.gestion_academica;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "asignatura")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignatura")
    private Long idAsignatura;
    @Column(name = "nombre_asignatura")
    private String nombreAsignatura;
    @Column(name = "cod_asignatura")
    private String codAsignatura;
}
