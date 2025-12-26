package com.midia.sistema_notas.entities.facturacion;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "impuesto")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Impuesto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_impuesto")
    private Long id_impuesto;
    @Column(name = "valor_porcentaje")
    private float valor_porcentaje;
    @Column(name = "impuesto")
    private String impuesto;

}
