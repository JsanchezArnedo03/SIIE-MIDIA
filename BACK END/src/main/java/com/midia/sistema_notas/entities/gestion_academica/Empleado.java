package com.midia.sistema_notas.entities.gestion_academica;

import com.midia.sistema_notas.entities.catalogos.Empresa;
import com.midia.sistema_notas.entities.gestion_academica.Persona;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Table(name = "empleado")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleado extends Persona {

    @Column(name = "fecha_contratacion", nullable = false)
    private Date fechaContratacion;

    @Column(name = "salario")
    private BigDecimal salario;

    @ManyToOne
    @JoinColumn(name ="id_cargo" )
    private Cargo cargo; // Cambiado de idCargo a cargo (es el objeto completo)

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_empresa")
    private Empresa empresa; // Cambiado de idEmpresa a empresa

    // LA RELACIÓN @OneToOne Persona idPersona FUE ELIMINADA
}