package com.midia.sistema_notas.entities.catalogos;

import com.midia.sistema_notas.entities.catalogos.Rol;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "permiso_rol")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermisoRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPermisoRol;

    @Column(name = "permiso_rol")
    private String permisoRol;

    @ManyToOne
    @JoinColumn(name = "fk_rol")
    private Rol rol; // ✅ correcto
}