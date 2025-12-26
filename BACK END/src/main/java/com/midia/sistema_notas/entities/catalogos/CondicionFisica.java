package com.midia.sistema_notas.entities.catalogos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "condicion_fisica")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CondicionFisica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_condicion_fisica")
    private Long idCondicionFisica;
    @Column(name = "condicion_fisica")
    private String condicionFisica;
    @Column(name = "cod_condicion")
    private String codCondicion;

}



