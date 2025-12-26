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
    @ManyToOne(fetch = FetchType.EAGER) // Muchos estudiantes tienen un mismo tipo de documento
    @JoinColumn(name = "id_tipo_documento")
    private TipoDocumento idTipoDocumento;
    @Column(name = "numero_documento")
    private String numeroDocumento;
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    @Column(name = "primer_nombre")
    private String primerNombre;
    @Column(name = "segundo_nombre")
    private String segundoNombre;
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @ManyToOne(fetch = FetchType.EAGER) // Muchos estudiantes tienen un mismo tipo de documento
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
}
