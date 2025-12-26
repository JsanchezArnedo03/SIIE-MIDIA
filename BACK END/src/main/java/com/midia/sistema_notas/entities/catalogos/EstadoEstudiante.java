package com.midia.sistema_notas.entities.catalogos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "estado_estudiante")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadoEstudiante {

    /*1. aprobada 2. reprobada 3. suspendida 4. matriculada*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_estudiante")
    private Long idPersona;
    @Column(name = "estado_estudiante")
    private String estadoEstudiante;

}
