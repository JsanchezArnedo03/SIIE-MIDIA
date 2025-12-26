package com.midia.sistema_notas.dto.catalogosDTO;

import com.midia.sistema_notas.entities.catalogos.TipoDocumento;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TipoDocumentoDTO {
    private Long idTipoDocumento;
    private String tipoDocumento;
    private String codTipoDocumento;

    public TipoDocumentoDTO() {
    }

    public TipoDocumentoDTO(TipoDocumento tipoDocumento) {
    }

    public TipoDocumentoDTO toDTO(TipoDocumento tipoDocumento) {
        return new TipoDocumentoDTO(tipoDocumento);
    }
}
