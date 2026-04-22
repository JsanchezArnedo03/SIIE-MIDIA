package com.midia.sistema_notas.entities.catalogos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "ciudad")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ciudad")
    private int idCiudad;

    @Column(name = "nombre_ciudad")
    private String nombreCiudad;

    @ManyToOne(fetch = FetchType.LAZY)
    private Departamento fkDepartamento;

    @ManyToOne(fetch = FetchType.LAZY)
    private Pais fkPais;
}
