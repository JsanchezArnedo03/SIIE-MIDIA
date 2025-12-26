package com.midia.sistema_notas.dto.gestion_academicaDTO;



import com.midia.sistema_notas.entities.gestion_academica.Grado;
import lombok.Data;
@Data
public class GradoDTO {

    private Long idGrado;
    private String grado;
    private String codGrado;

    public GradoDTO() {
    }

    public GradoDTO(Grado grado) {
    }

    public GradoDTO toDTO(Grado grado) {
        return new GradoDTO(grado);
    }
}
