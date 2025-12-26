package com.midia.sistema_notas.dto.contabilidadDTO;


import com.midia.sistema_notas.entities.contabilidad.MetodoPago;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MetodoPagoDTO {
    private Long id;
    private String metodo;

    public MetodoPagoDTO() {
    }

    public MetodoPagoDTO(MetodoPago metodoPago) {
    }

    public MetodoPagoDTO toDTO(MetodoPago metodoPago) {
        return new MetodoPagoDTO(metodoPago);
    }
}
