package com.midia.sistema_notas.dto.catalogosDTO;

import com.midia.sistema_notas.entities.catalogos.TipoDocumento;
import com.midia.sistema_notas.entities.catalogos.TipoSangre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class TipoSangreDTO {
    private Long idTipoSangre;
    private String tipoSangre;

    public TipoSangreDTO() {
    }

    public TipoSangreDTO(TipoSangre tipoSangre) {
    }

    public TipoSangreDTO toDTO(TipoSangre tipoSangre) {
        return new TipoSangreDTO(tipoSangre);
    }
}
