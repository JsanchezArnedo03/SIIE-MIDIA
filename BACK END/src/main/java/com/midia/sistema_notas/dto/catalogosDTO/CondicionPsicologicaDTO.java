package com.midia.sistema_notas.dto.catalogosDTO;


import com.midia.sistema_notas.entities.catalogos.CondicionPsicologica;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CondicionPsicologicaDTO {

    private Long idCondicionPsicologica;
    private String condicionPsicologica;
    private String descripcion;

    public CondicionPsicologicaDTO() {
    }

    public CondicionPsicologicaDTO(CondicionPsicologica condicionPsicologica) {
    }

    public static CondicionPsicologicaDTO toDTO(CondicionPsicologica condicionPsicologica) {
        return new CondicionPsicologicaDTO(condicionPsicologica);
    }
}
