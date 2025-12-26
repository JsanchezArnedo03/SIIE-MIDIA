package com.midia.sistema_notas.dto.gestion_academicaDTO;



import com.midia.sistema_notas.entities.gestion_academica.EmpleadoXAsignatura;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmpleadoXAsignaturaDTO {

    private Long id;
    private AsignaturaDTO asignatura;
    private PersonaDTO empleado;

    public EmpleadoXAsignaturaDTO() {
    }

    public EmpleadoXAsignaturaDTO(EmpleadoXAsignatura empleadoXAsignatura) {
    }

    public EmpleadoXAsignaturaDTO toDTO(EmpleadoXAsignatura empleadoXAsignatura) {
        return new EmpleadoXAsignaturaDTO(empleadoXAsignatura);
    }
}
