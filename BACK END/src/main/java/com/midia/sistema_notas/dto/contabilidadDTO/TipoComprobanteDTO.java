package com.midia.sistema_notas.dto.contabilidadDTO;


import com.midia.sistema_notas.entities.contabilidad.TipoComprobante;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TipoComprobanteDTO {
    private Long idTipoComprobante;
    private String tipoComprobante;

    public TipoComprobanteDTO() {
    }

    public TipoComprobanteDTO(TipoComprobante tipoComprobante) {
    }

    public TipoComprobanteDTO toDTO(TipoComprobante tipoComprobante) {
        return new TipoComprobanteDTO(tipoComprobante);
    }
}
