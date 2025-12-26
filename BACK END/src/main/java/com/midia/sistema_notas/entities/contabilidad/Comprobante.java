package com.midia.sistema_notas.entities.contabilidad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "comprobante")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comprobante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comprobante")
    private Long idComprobante;
    @ManyToOne
    @JoinColumn(name = "id_tipo_comprobante")
    private TipoComprobante idTipoComprobante;
    @Column(name = "fecha_registro")
    private Date fechaRegistro;
    @Column(name = "descripcion")
    private String description;
    @Column(name = "consecutivo")
    private String consecutivo;
    @ManyToOne
    @JoinColumn(name = "id_estado_comprobante")
    private EstadoComprobante idEstadoComprobante;

}
