package com.midia.sistema_notas.entities.gestion_academica;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "tipo_actividad")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoActividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_actividad")
    private Long idTipoActividad;
    @Column(name = "tipo_actividad")
    private String tipo_actividad;
}
