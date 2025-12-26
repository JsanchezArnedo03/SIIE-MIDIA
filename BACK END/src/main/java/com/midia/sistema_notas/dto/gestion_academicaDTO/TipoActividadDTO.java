package com.midia.sistema_notas.dto.gestion_academicaDTO;

import com.midia.sistema_notas.entities.gestion_academica.TipoActividad;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoActividadDTO {
    private Long idTipoActividad;
    private String tipoActividad;

    public TipoActividadDTO(TipoActividad tipoActividad){}

    public TipoActividadDTO toDTO(TipoActividad tipoActividad){
        return new TipoActividadDTO(tipoActividad);
    }
}
