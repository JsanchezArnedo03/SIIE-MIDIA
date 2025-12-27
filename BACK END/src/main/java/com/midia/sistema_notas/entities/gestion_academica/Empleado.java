package com.midia.sistema_notas.entities.gestion_academica;

import com.midia.sistema_notas.entities.catalogos.Empresa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Table(name = "empleado")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Long idEmpleado;
    @Column(name = "fecha_contratacion", nullable = false)
    private Date fechaContratacion;
    @Column(name = "salario")
    private BigDecimal salario;
    @ManyToOne
    @JoinColumn(name ="id_cargo" )
    private Cargo idCargo;
    @OneToOne
    @JoinColumn(name = "id:persona")
    private Persona idPersona;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_empresa")
    private Empresa idEmpresa;
}
