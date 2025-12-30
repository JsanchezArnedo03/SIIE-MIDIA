package com.midia.sistema_notas.dto.gestion_academicaDTO;



import com.midia.sistema_notas.dto.catalogosDTO.EmpresaDTO;
import com.midia.sistema_notas.entities.gestion_academica.Matricula;
import com.midia.sistema_notas.enums.EstadoEstudiante;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class MatriculaDTO {


    private Long id;
    private EstudianteDTO estudiante;
    private GradoDTO grado;
    private EstadoEstudiante estadoEstudiante;
    private Date fecha_matricula;
    private String observaciones;
    private EmpresaDTO empresa;

    public MatriculaDTO() {
    }

    public MatriculaDTO(Matricula estudianteXGrado) {
    }

    public MatriculaDTO toDTO(Matricula estudianteXGrado) {
        return new MatriculaDTO(estudianteXGrado);
    }
}
