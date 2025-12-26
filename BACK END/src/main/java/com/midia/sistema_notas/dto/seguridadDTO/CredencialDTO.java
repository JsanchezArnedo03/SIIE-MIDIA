package com.midia.sistema_notas.dto.seguridadDTO;


import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CredencialDTO {

    private Long id;
    private String username;
    private String password;

    private RolDTO rol;
}
