package com.midia.sistema_notas.entities.gestion_academica;

import com.midia.sistema_notas.dto.catalogosDTO.EmpresaDTO;
import com.midia.sistema_notas.dto.gestion_academicaDTO.EstudianteDTO;
import com.midia.sistema_notas.entities.catalogos.*;
import com.midia.sistema_notas.enums.EstadoEstudiante;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "estudiante")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Long idEstudiante;
    @ManyToOne
    @JoinColumn(name = "id_tipo_sangre")
    private TipoSangre idTipoSangre;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tipo_condicion_fisica")
    private CondicionFisica idTipoCondicionFisica;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tipo_condicion_psicologica")
    private CondicionPsicologica idTipoCondicionPsicologica;
    @Enumerated(EnumType.STRING)
    @Column(name = "id_estado_estudiante")
    private EstadoEstudiante estadoEstudiante = EstadoEstudiante.MATRICULADO;
    @OneToOne
    @JoinColumn(name = "id_persona")
    private Persona id_persona;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_empresa")
    private Empresa idEmpresa;

    public Estudiante(EstudianteDTO estudianteDTO) {

    }

    public static Estudiante toEntity(EstudianteDTO estudianteDTO) {
        return new Estudiante(estudianteDTO);
    }
}
