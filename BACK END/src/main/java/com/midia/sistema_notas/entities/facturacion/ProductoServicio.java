package com.midia.sistema_notas.entities.facturacion;

import com.midia.sistema_notas.entities.catalogos.Empresa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "producto_servicio")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto_servicio")
    private Long idProductoServicio;
    @Column(name = "cod_producto_servicio")
    private String codProductoServicio;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "precio_unitario")
    private float precioUnitario;
    @Column(name = "codigo_dian")
    private String codigoDian;
    @ManyToOne
    @JoinColumn(name = "impuestos_aplicables")
    private Impuesto impuestoAplicable;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_empresa")
    private Empresa idEmpresa;
}
