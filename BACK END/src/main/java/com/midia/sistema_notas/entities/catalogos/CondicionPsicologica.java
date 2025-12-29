package com.midia.sistema_notas.entities.catalogos;

import com.midia.sistema_notas.dto.catalogosDTO.CondicionFisicaDTO;
import com.midia.sistema_notas.dto.catalogosDTO.CondicionPsicologicaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "condicion_psicologica")
@Entity
@Data
@AllArgsConstructor
public class CondicionPsicologica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_condicion_psicologica")
    private Long idCondicionPsicologica;
    @Column(name = "condicion_psicologica")
    private String condicionPsicologica;
    @Column(name = "descripcion")
    private String descripcion;

    public CondicionPsicologica() {
    }

    public CondicionPsicologica(CondicionPsicologicaDTO condicionPsicologicaDTO) {
    }

    public static CondicionPsicologica toEntity(CondicionPsicologicaDTO CondicionPsicologicaDTO) {
        return new CondicionPsicologica(CondicionPsicologicaDTO);
    }
}
