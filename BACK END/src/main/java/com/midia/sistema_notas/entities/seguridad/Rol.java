package com.midia.sistema_notas.entities.seguridad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "rol")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rol {
    /*1. Empleado 2. Estudiante 3. Acudiente*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;
    @Column(name = "rol")
    private String rol;
}
