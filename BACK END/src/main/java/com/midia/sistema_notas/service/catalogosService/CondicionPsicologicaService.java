package com.midia.sistema_notas.service.catalogosService;


import com.midia.sistema_notas.dto.catalogosDTO.CondicionFisicaDTO;
import com.midia.sistema_notas.dto.catalogosDTO.CondicionPsicologicaDTO;
import com.midia.sistema_notas.entities.catalogos.CondicionPsicologica;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface CondicionPsicologicaService {


    List<CondicionPsicologicaDTO> findAll();

    ResponseEntity<CondicionPsicologicaDTO> create(CondicionPsicologicaDTO condicionPsicologicaDTO);

    Optional<CondicionPsicologicaDTO> findByName(@RequestParam String name);

    boolean update(CondicionPsicologicaDTO condicionPsicologicaDTO);
}
