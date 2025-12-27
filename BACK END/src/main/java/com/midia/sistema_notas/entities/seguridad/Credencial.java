package com.midia.sistema_notas.entities.seguridad;

import com.midia.sistema_notas.entities.catalogos.Empresa;
import com.midia.sistema_notas.entities.gestion_academica.Persona;
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
    @JoinColumn(name = "id_persona")
    private Persona persona;
    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa idEmpresa;
}
