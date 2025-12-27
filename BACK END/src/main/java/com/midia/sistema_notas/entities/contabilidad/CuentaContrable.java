package com.midia.sistema_notas.entities.contabilidad;

import com.midia.sistema_notas.entities.catalogos.Empresa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "cuentas_contables")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CuentaContrable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cuenta")
    private Long idCuenta;
    @Column(name = "codigo_puc")
    private Long codigoPuc;
    @Column(name = "nombre_cuenta")
    private String nombreCuenta;
    @Column(name = "tipo_cuenta")
    private String tipoCuenta;
    @Column(name = "naturaleza")
    private String naturaleza;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_empresa")
    private Empresa idEmpresa;
}
