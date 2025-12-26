package com.midia.sistema_notas.entities.seguridad;

import com.midia.sistema_notas.entities.gestion_academica.Estudiante;
import com.midia.sistema_notas.entities.gestion_academica.Persona;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "credencial_x_tipo_persona_and_persona")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CredencialAcceso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_credencial_x_tipo_persona_and_persona")
    private Long id;
    @OneToOne
    @JoinColumn(name = "id_credencial")
    private Credencial credencial;
    @OneToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;
    @OneToOne
    @JoinColumn(name = "id_empleado")
    private Persona empleado;
}
