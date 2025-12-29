package com.midia.sistema_notas.entities.catalogos;

import com.midia.sistema_notas.dto.catalogosDTO.EmpresaDTO;
import com.midia.sistema_notas.dto.catalogosDTO.TipoDocumentoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "tipo_documento")
@Entity
@Data
public class TipoDocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_documento")
    private Long idTipoDocumento;
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Column(name = "cod_tipo_documento")
    private String codTipoDocumento;

    public TipoDocumento(TipoDocumentoDTO tipoDocumentoDTO) {
        this.idTipoDocumento = tipoDocumentoDTO.getIdTipoDocumento();
        this.tipoDocumento = tipoDocumentoDTO.getTipoDocumento();
        this.codTipoDocumento = tipoDocumentoDTO.getCodTipoDocumento();
    }

    public static TipoDocumento toEntity(TipoDocumentoDTO tipoDocumentoDTO) {
        return new TipoDocumento(tipoDocumentoDTO);
    }
}
