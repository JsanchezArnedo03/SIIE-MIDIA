package com.midia.sistema_notas.entities.seguridad;

import com.midia.sistema_notas.entities.catalogos.Empresa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "log_acceso")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogAcceso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_log_acceso")
    private Long idLogAcceso;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "evento", nullable = false)
    private String evento; // Ej: "LOGIN_SUCCESS", "LOGIN_FAILED"

    @Column(name = "ip_origen", length = 45)
    private String ipOrigen;

    @Column(name = "user_agent", columnDefinition = "TEXT")
    private String userAgent; // Para saber desde qué navegador entraron

    @Column(name = "fecha_evento", updatable = false)
    private java.time.LocalDateTime fechaEvento;

    @PrePersist
    protected void onCreate() {
        this.fechaEvento = java.time.LocalDateTime.now();
    }
}