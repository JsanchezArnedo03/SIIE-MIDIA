package com.midia.sistema_notas.entities.seguridad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "credencial")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Credencial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_credencial")
    private Long id;
    @Column(name = "username_")
    private String username;
    @Column(name = "password_")
    private String password;
    @OneToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;
}
