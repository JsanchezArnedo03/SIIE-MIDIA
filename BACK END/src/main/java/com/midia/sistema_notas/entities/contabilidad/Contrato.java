package com.midia.sistema_notas.entities.contabilidad;

import com.midia.sistema_notas.entities.catalogos.Empresa;
import com.midia.sistema_notas.entities.gestion_academica.Persona;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "contrato")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contrato")
    private Long id;
    @Column(name = "fecha_inicio_periodo")
    private Date fechaInicioContrato;
    @Column(name = "fecha_fin_periodo")
    private Date fechaFinContrato;
    @OneToOne
    @JoinColumn(name = "persona")
    private Persona empleado;
    @Column(name = "contrato_pdf")
    private byte[] contratoPDF;
    @Column(name = "ruta_contrato")
    private String contratoRuta;

    @JoinColumn(name = "id_empresa")
    private Empresa idEmpresa;
}
