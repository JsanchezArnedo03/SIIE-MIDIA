package com.midia.sistema_notas.service.gestion_academicaService;

import com.midia.sistema_notas.dto.gestion_academicaDTO.EstudianteDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

public interface EstudianteService {
    ResponseEntity<Object> createEstudiante(@RequestBody EstudianteDTO estudiante, @RequestHeader("Authorization")String token);
    ResponseEntity<String> retirarEstudiante(@RequestParam String documento, @RequestHeader("Authorization")String token);
}
