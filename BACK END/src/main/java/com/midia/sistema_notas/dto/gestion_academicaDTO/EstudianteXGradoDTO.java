package com.midia.sistema_notas.dto.gestion_academicaDTO;



import com.midia.sistema_notas.entities.gestion_academica.EstudianteXGrado;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EstudianteXGradoDTO {


    private Long id;
    private EstudianteDTO estudiante;
    private GradoDTO grado;

    public EstudianteXGradoDTO() {
    }

    public EstudianteXGradoDTO(EstudianteXGrado estudianteXGrado) {
    }

    public EstudianteXGradoDTO toDTO(EstudianteXGrado estudianteXGrado) {
        return new EstudianteXGradoDTO(estudianteXGrado);
    }
}
