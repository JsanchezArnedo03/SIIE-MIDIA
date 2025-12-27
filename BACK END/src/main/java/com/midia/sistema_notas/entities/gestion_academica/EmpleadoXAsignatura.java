package com.midia.sistema_notas.entities.gestion_academica;

import com.midia.sistema_notas.entities.catalogos.Empresa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "empleado_x_asignatura")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoXAsignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado_x_asignatura")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_asignatura")
    private Asignatura asignatura;
    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Persona empleado;
    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa idEmpresa;
}
