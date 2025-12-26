package com.midia.sistema_notas.entities.contabilidad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "estado_comprobante")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadoComprobante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_comprobante")
    private Long idEstadoComprobante;
    @Column(name = "descripcion")
    private String descripcion;
}
