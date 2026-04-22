package com.midia.sistema_notas.entities.catalogos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.midia.sistema_notas.entities.catalogos.Pais;

@Table(name = "departamento")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Departamento {
    @Id
    @Column(name = "id_departamento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDepartamento;

    @Column(name = "nombre_departamento")
    private String nombreDepartamento;

    @ManyToOne(fetch = FetchType.LAZY)
    private Pais fkPais;
}
