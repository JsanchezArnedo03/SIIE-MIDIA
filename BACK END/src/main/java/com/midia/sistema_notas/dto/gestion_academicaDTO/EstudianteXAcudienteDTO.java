package com.midia.sistema_notas.dto.gestion_academicaDTO;



import com.midia.sistema_notas.entities.gestion_academica.EstudianteXAcudiente;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EstudianteXAcudienteDTO {

    private Long id;
    private EstudianteDTO estudiante;
    private PersonaDTO acudiente;

    public EstudianteXAcudienteDTO() {
    }

    public EstudianteXAcudienteDTO(EstudianteXAcudiente estudianteXAcudiente) {
    }

    public EstudianteXAcudienteDTO toDTO(EstudianteXAcudiente estudianteXAcudiente) {
        return new EstudianteXAcudienteDTO(estudianteXAcudiente);
    }
}
