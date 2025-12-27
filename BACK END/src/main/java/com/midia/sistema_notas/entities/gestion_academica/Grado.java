package com.midia.sistema_notas.entities.gestion_academica;

import com.midia.sistema_notas.entities.catalogos.Empresa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "grado")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grado")
    private Long idGrado;
    @Column(name = "grado")
    private String grado;
    @Column(name = "cod_grado")
    private String codGrado;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_empresa")
    private Empresa idEmpresa;
}
