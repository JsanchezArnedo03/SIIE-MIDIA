package com.midia.sistema_notas.service.catalogosService;

import com.midia.sistema_notas.dto.catalogosDTO.TipoDocumentoDTO;

import java.util.List;
import java.util.Optional;

public interface TipoDocumentoService {

    List<TipoDocumentoDTO> findAll();

    Optional<TipoDocumentoDTO> findByName(String name);
}
