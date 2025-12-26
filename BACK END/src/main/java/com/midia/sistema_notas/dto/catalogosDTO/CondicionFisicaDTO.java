package com.midia.sistema_notas.dto.catalogosDTO;

import com.midia.sistema_notas.entities.catalogos.CondicionFisica;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
public class CondicionFisicaDTO {

    private Long idCondicionFisica;
    private String condicionFisica;
    private String codCondicion;

    public CondicionFisicaDTO(){

    }

    public CondicionFisicaDTO(CondicionFisica condicionFisica) {
    }

    public CondicionFisicaDTO toDTO(CondicionFisica condicionFisica){
        return new CondicionFisicaDTO(condicionFisica);
    }
}



