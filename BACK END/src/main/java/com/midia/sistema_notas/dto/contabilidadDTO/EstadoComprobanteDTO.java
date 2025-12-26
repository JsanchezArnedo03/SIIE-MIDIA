package com.midia.sistema_notas.dto.contabilidadDTO;


import com.midia.sistema_notas.entities.contabilidad.EstadoComprobante;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EstadoComprobanteDTO {
    private Long idEstadoComprobante;
    private String descripcion;

    public EstadoComprobanteDTO() {
    }

    public EstadoComprobanteDTO(EstadoComprobante estadoComprobante) {
    }

    public EstadoComprobanteDTO toDTO(EstadoComprobante estadoComprobante) {
        return new EstadoComprobanteDTO(estadoComprobante);
    }
}
