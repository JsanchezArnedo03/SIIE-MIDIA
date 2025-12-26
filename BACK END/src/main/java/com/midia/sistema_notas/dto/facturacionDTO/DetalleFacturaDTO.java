package com.midia.sistema_notas.dto.facturacionDTO;


import com.midia.sistema_notas.entities.facturacion.DetalleFactura;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DetalleFacturaDTO {
    private Long idDetalleFactura;
    private FacturaDTO idFactura;
    private ProductoServicioDTO idProducto;
    private Integer cantidad;
    private Float precioUnitario;

    public DetalleFacturaDTO() {
    }

    public DetalleFacturaDTO(DetalleFactura detalleFactura) {
    }

    public DetalleFacturaDTO toDTO(DetalleFactura detalleFactura) {
        return new DetalleFacturaDTO(detalleFactura);
    }
}
