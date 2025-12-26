package com.midia.sistema_notas.entities.catalogos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "tipo_sangre")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoSangre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_sangre")
    private Long idTipoSangre;
    @Column(name = "tipo_sangre")
    private String tipoSangre;
}
