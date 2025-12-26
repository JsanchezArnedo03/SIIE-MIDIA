package com.midia.sistema_notas.dto.contabilidadDTO;

import com.midia.sistema_notas.dto.catalogosDTO.TipoDocumentoDTO;
import com.midia.sistema_notas.dto.gestion_academicaDTO.PersonaDTO;
import com.midia.sistema_notas.entities.catalogos.TipoDocumento;
import com.midia.sistema_notas.entities.contabilidad.Contrato;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ContratoDTO {

    private Long id;
    private Date fechaInicioContrato;
    private Date fechaFinContrato;
    private PersonaDTO empleado;
    private Byte[] contratoPDF;

    public ContratoDTO() {
    }

    public ContratoDTO(Contrato contrato) {
    }

    public ContratoDTO toDTO(Contrato contrato) {
        return new ContratoDTO(contrato);
    }
}
