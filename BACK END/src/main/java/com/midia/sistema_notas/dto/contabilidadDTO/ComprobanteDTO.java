package com.midia.sistema_notas.dto.contabilidadDTO;


import com.midia.sistema_notas.entities.contabilidad.Comprobante;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ComprobanteDTO {

    private Long idComprobante;
    private TipoComprobanteDTO  idTipoComprobante;
    private Date fechaRegistro;
    private String descripcion;
    private String consecutivo;
    private EstadoComprobanteDTO idEstadoComprobante;

    public ComprobanteDTO() {
    }

    public ComprobanteDTO(Comprobante comprobante) {
    }

    public ComprobanteDTO toDTO(Comprobante comprobante) {
        return new ComprobanteDTO(comprobante);
    }
}
