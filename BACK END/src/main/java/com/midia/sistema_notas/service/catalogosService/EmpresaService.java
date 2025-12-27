package com.midia.sistema_notas.service.catalogosService;


import com.midia.sistema_notas.dto.catalogosDTO.EmpresaDTO;

import java.util.List;
import java.util.Optional;

public interface EmpresaService {


    List<EmpresaDTO> findAll();

    Optional<EmpresaDTO> findById(Long id);
}
