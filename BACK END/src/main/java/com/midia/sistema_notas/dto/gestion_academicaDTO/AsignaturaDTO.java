package com.midia.sistema_notas.dto.gestion_academicaDTO;



import com.midia.sistema_notas.entities.gestion_academica.Asignatura;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AsignaturaDTO {
    private Long idAsignatura;
        private String nombreAsignatura;

    private String codAsignatura;

    public AsignaturaDTO() {
    }

    public AsignaturaDTO(Asignatura asignatura) {
    }

    public AsignaturaDTO toDTO(Asignatura asignatura) {
        return new AsignaturaDTO(asignatura);
    }
}
