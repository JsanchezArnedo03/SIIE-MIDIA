package com.midia.sistema_notas.entities.gestion_academica;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "cargo")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cargo")
    private Long idCargo;

    @Column(name = "cargo")
    private String cargo;
}
