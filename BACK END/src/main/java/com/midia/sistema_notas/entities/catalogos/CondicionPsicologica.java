package com.midia.sistema_notas.entities.catalogos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "condicion_psicologica")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CondicionPsicologica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_condicion_psicologica")
    private Long idCondicionPsicologica;
    @Column(name = "condicion_psicologica")
    private String condicionPsicologica;
    @Column(name = "cod_condicion")
    private String codCondicion;
}
