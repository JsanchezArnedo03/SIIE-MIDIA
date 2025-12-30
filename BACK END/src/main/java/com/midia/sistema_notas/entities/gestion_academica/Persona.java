package com.midia.sistema_notas.entities.gestion_academica;

import com.midia.sistema_notas.entities.catalogos.TipoDocumento;
import com.midia.sistema_notas.entities.seguridad.Rol;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "persona")
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Long idPersona;
    @ManyToOne(fetch = FetchType.EAGER) // Muchos estudiantes tienen un mismo tipo de documento
    @JoinColumn(name = "id_tipo_documento")
    private TipoDocumento idTipoDocumento;
    @Column(name = "numero_documento")
    private String numeroDocumento;
    @Column(name = "primer_nombre")
    private String primerNombre;
    @Column(name = "segundo_nombre")
    private String segundoNombre;
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Column(name = "telefono_1")
    private String telefono1;
    @Column(name = "email")
    private String email;
    @ManyToOne(fetch = FetchType.EAGER) // Muchas personas tienen un mismo tipo de rol
    @JoinColumn(name = "id_rol")
    private Rol rol;
}
