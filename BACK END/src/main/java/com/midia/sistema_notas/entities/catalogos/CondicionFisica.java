package com.midia.sistema_notas.entities.catalogos;

import com.midia.sistema_notas.dto.catalogosDTO.CondicionFisicaDTO;
import com.midia.sistema_notas.dto.catalogosDTO.CondicionPsicologicaDTO;
import com.midia.sistema_notas.dto.catalogosDTO.EmpresaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "condicion_fisica")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CondicionFisica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_condicion_fisica")
    private Long idCondicionFisica;
    @Column(name = "condicion_fisica")
    private String condicionFisica;
    @Column(name = "descripcion")
    private String descripcion;

    public CondicionFisica(CondicionFisicaDTO condicionFisicaDTO) {
        if (condicionFisicaDTO != null) {
            this.idCondicionFisica = condicionFisicaDTO.getIdCondicionFisica();
            this.condicionFisica = condicionFisicaDTO.getCondicionFisica();
            this.descripcion = condicionFisicaDTO.getDescripcion();
        }
    }

    public CondicionFisica(CondicionPsicologicaDTO condicionPsicologicaDTO) {
    }

    public static CondicionFisica toEntity(CondicionFisicaDTO condicionFisicaDTO) {
        return new CondicionFisica(condicionFisicaDTO);
    }
}



