package com.midia.sistema_notas.dto.seguridadDTO;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class RolDTO {
    /*1. Empleado 2. Estudiante 3. Acudiente*/

    private Long idRol;

    private String rol;
}
