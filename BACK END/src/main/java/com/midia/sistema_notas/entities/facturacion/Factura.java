package com.midia.sistema_notas.entities.facturacion;

import com.midia.sistema_notas.entities.catalogos.Empresa;
import com.midia.sistema_notas.entities.contabilidad.MetodoPago;
import com.midia.sistema_notas.entities.gestion_academica.Persona;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "factura")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private Long idFactura;
    @Column(name = "fecha_venta")
    private Date fechaVenta;
    @Column(name = "fecha_vencimiento")
    private Date fechaVencimiento;
    @Column(name = "descripcion_venta")
    private String descripcionVenta;
    @ManyToOne
    @JoinColumn(name = "estado_factura")
    private EstadoFactura estadoFactura;
    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa idEmpresa;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Persona idCliente;
    @ManyToOne
    @JoinColumn(name = "metodo_pago")
    private MetodoPago metodoPago;
}
