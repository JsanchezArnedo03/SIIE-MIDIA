package com.midia.sistema_notas.entities.gestion_academica;

import com.midia.sistema_notas.entities.catalogos.*;
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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_estado_estudiante")
    private EstadoEstudiante idEstadoEstudiante;
    @OneToOne
    @JoinColumn(name = "id_persona")
    private Persona id_persona;
}
