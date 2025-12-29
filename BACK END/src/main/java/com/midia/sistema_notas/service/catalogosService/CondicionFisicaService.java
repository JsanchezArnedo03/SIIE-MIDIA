package com.midia.sistema_notas.service.catalogosService;


import com.midia.sistema_notas.dto.catalogosDTO.CondicionFisicaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface CondicionFisicaService {

    List<CondicionFisicaDTO> findAll();

    ResponseEntity<CondicionFisicaDTO> create(@RequestBody CondicionFisicaDTO condicionFisicaDTO);

    Optional<CondicionFisicaDTO> findByName(@RequestParam String name);
}



