package com.midia.sistema_notas.dto.facturacionDTO;

import com.midia.sistema_notas.entities.facturacion.Impuesto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ImpuestoDTO {


    private Long id_impuesto;
    private float valor_porcentaje;
    private String impuesto;

    public ImpuestoDTO() {
    }

    public ImpuestoDTO(Impuesto impuesto) {
    }

    public ImpuestoDTO toDTO(Impuesto impuesto) {
        return new ImpuestoDTO(impuesto);
    }
}
