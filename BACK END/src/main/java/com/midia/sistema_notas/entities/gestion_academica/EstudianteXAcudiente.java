package com.midia.sistema_notas.entities.gestion_academica;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estudiante_x_acudiente", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id_estudiante", "id_acudiente"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteXAcudiente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante_x_acudiente")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_estudiante")// más de 1 estudiante puede tener el mismo acudiente
    private Estudiante estudiante;
    @ManyToOne
    @JoinColumn(name = "id_acudiente")
    private Persona acudiente;

}
