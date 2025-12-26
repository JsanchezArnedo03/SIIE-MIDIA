package com.midia.sistema_notas.dto.facturacionDTO;



import com.midia.sistema_notas.entities.facturacion.ProductoServicio;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductoServicioDTO {

    private Long idProductoServicio;
    private String codProductoServicio;
    private String descripcion;
    private float precioUnitario;
    private String codigoDian;
    private ImpuestoDTO impuestosAplicables;

    public ProductoServicioDTO() {
    }

    public ProductoServicioDTO(ProductoServicio tipoDocumento) {
    }

    public ProductoServicioDTO toDTO(ProductoServicio tipoDocumento) {
        return new ProductoServicioDTO(tipoDocumento);
    }
}
