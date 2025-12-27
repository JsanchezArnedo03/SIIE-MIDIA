package com.midia.sistema_notas.dto.seguridadDTO;

import com.midia.sistema_notas.entities.seguridad.Rol;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class RolDTO {

    private Long idRol;
    private String rol;

    public RolDTO() {
    }

    public RolDTO(Rol rol) {
    }

    public RolDTO toDTO(Rol rol) {
        return new RolDTO(rol);
    }
}
