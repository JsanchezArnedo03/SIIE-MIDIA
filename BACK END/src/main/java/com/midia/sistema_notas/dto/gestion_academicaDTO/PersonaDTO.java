package com.midia.sistema_notas.dto.gestion_academicaDTO;


import com.midia.sistema_notas.dto.catalogosDTO.TipoDocumentoDTO;
import com.midia.sistema_notas.dto.seguridadDTO.RolDTO;

import com.midia.sistema_notas.entities.gestion_academica.Persona;
import lombok.Data;

@Data
public class PersonaDTO {

    private Long idPersona;
    private TipoDocumentoDTO idTipoDocumento;
    private String numeroDocumento;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String telefono1;
    private String email;
    private RolDTO rol;

    public PersonaDTO() {
    }

    public PersonaDTO(Persona persona) {
    }

    public PersonaDTO toDTO(Persona persona) {
        return new PersonaDTO(persona);
    }
}
