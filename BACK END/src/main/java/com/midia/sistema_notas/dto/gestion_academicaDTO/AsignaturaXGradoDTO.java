package com.midia.sistema_notas.dto.gestion_academicaDTO;

import com.midia.sistema_notas.entities.gestion_academica.AsignaturaXGrado;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AsignaturaXGradoDTO {

    private Long id;
    private AsignaturaDTO asignatura;
    private GradoDTO grado;

    public AsignaturaXGradoDTO() {
    }

    public AsignaturaXGradoDTO(AsignaturaXGrado asignaturaXGrado) {
    }

    public AsignaturaXGradoDTO toDTO(AsignaturaXGrado asignaturaXGrado) {
        return new AsignaturaXGradoDTO(asignaturaXGrado);
    }
}
