package com.midia.sistema_notas.entities.facturacion;

import com.midia.sistema_notas.entities.catalogos.Empresa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "detalle_factura")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_factura")
    private Long idDetalleFactura;
    @ManyToOne
    @JoinColumn(name = "id_factura")
    private Factura idFactura;
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private ProductoServicio idProducto;
    @Column(name ="cantidad")
    private Integer cantidad;
    @Column(name = "precio_unitario")
    private Float precioUnitario;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_empresa")
    private Empresa idEmpresa;
}
