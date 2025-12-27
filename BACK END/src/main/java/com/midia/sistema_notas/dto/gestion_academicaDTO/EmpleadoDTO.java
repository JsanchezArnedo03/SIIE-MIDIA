package com.midia.sistema_notas.dto.gestion_academicaDTO;

import com.midia.sistema_notas.entities.gestion_academica.Cargo;
import com.midia.sistema_notas.entities.gestion_academica.Empleado;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
public class EmpleadoDTO {
    private Long idEmpleado;
    private Date fechaContratacion;
    private BigDecimal salario;
    private Cargo idCargo;
    private PersonaDTO idPersona;


    public EmpleadoDTO() {
    }

    public EmpleadoDTO(Empleado empleado) {

    }

    public EmpleadoDTO toDTO(Empleado empleado) {
        return new EmpleadoDTO(empleado);
    }
}
