package com.midia.sistema_notas.dto.seguridadDTO;

import com.midia.sistema_notas.dto.gestion_academicaDTO.EstudianteDTO;
import com.midia.sistema_notas.dto.gestion_academicaDTO.PersonaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CredencialAccesoDTO {

    private Long id;

    private CredencialDTO credencial;

    private EstudianteDTO estudiante;

    private PersonaDTO empleado;
}
