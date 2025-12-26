package com.midia.sistema_notas.dto.facturacionDTO;

import com.midia.sistema_notas.dto.catalogosDTO.EmpresaDTO;
import com.midia.sistema_notas.dto.contabilidadDTO.MetodoPagoDTO;
import com.midia.sistema_notas.dto.gestion_academicaDTO.PersonaDTO;
import com.midia.sistema_notas.entities.facturacion.Factura;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class FacturaDTO {
    private Long idFactura;
    private Date fechaVenta;
    private Date fechaVencimiento;
    private String descripcionVenta;
    private EstadoFacturaDTO estadoFactura;
    private EmpresaDTO idEmpresa;
    private PersonaDTO idCliente;
    private MetodoPagoDTO metodoPago;

    public FacturaDTO() {
    }

    public FacturaDTO(Factura factura) {
    }

    public FacturaDTO toDTO(Factura factura) {
        return new FacturaDTO(factura);
    }
}
