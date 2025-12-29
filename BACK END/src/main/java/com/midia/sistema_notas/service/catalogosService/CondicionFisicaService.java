package com.midia.sistema_notas.service.catalogosService;


import com.midia.sistema_notas.dto.catalogosDTO.CondicionFisicaDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CondicionFisicaService {

    List<CondicionFisicaDTO> findAll();

    ResponseEntity<CondicionFisicaDTO> create(CondicionFisicaDTO condicionFisicaDTO);
}



