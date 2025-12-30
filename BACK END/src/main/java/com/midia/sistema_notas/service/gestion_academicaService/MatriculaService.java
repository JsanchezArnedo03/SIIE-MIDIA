package com.midia.sistema_notas.service.gestion_academicaService;

import com.midia.sistema_notas.dto.gestion_academicaDTO.MatriculaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

public interface MatriculaService {

    ResponseEntity<String> matricular(@RequestBody MatriculaDTO matricula, @RequestHeader("Authorization") String token);
    ResponseEntity<String> promovido ();


}
