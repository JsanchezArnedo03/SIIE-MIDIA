package com.midia.sistema_notas.dto.facturacionDTO;


import com.midia.sistema_notas.entities.facturacion.EstadoFactura;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EstadoFacturaDTO {
    private Long idEstadoFactura;
    private String estadoFactura;

    public EstadoFacturaDTO() {
    }

    public EstadoFacturaDTO(EstadoFactura estadoFactura) {
    }

    public EstadoFacturaDTO toDTO(EstadoFactura estadoFactura) {
        return new EstadoFacturaDTO(estadoFactura);
    }
}
