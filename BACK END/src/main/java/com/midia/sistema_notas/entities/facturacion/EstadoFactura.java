package com.midia.sistema_notas.entities.facturacion;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "estado_factura")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadoFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_factura")
    private Long idEstadoFactura;
    @Column(name = "estado_factura")
    private String estadoFactura;
}
