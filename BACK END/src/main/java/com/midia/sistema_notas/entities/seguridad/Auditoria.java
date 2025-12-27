package com.midia.sistema_notas.entities.seguridad;

import com.midia.sistema_notas.entities.catalogos.Empresa;
import com.midia.sistema_notas.entities.gestion_academica.Persona;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "auditoria")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_auditoria")
    private Long idAuditoria;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Persona persona;
    @Column(name = "tabla_afectada")
    private String tablaAfectada;
    @Column(name = "operacion")
    private String operacion;
    @Column(name = "valor_anterior")
    private String valorAnterior;
    @Column(name = "valor_nuevo")
    private String valorNuevo;
    @Column(name = "direccion_ip")
    private String direccionIp;
    @Column(name = "fecha_accion")
    private java.time.LocalDateTime fechaAccion;

    // Este metodo asegura que la fecha se ponga sola antes de guardar
    @PrePersist
    protected void onCreate() {
        this.fechaAccion = java.time.LocalDateTime.now();
    }

}
