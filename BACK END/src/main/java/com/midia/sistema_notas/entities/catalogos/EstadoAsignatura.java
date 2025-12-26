package com.midia.sistema_notas.entities.catalogos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "estado_asignatura")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadoAsignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_asignatura")
    private Long idEstadoAsignatura;
    @Column(name = "estado_asignatura")
     private String estadoAsignatura;
}
