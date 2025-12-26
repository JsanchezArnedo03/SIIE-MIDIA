package com.midia.sistema_notas.entities.contabilidad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "tipo_comprobante")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoComprobante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_comprobante")
    private Long idTipoComprobante;
    @Column(name = "tipo_comprobante")
    private String tipoComprobante;
}
