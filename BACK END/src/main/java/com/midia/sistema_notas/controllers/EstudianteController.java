package com.midia.sistema_notas.controllers;

import com.midia.sistema_notas.dto.gestion_academicaDTO.EstudianteDTO;
import com.midia.sistema_notas.entities.gestion_academica.Estudiante;
import com.midia.sistema_notas.service.gestion_academicaService.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/api/estudiante")
public class EstudianteController {
    @Autowired
    private EstudianteService service;

    @PostMapping("/crear")
    public ResponseEntity<EstudianteDTO> createEstudiante(@RequestBody EstudianteDTO estudiante, @RequestHeader("Authorization") String token) {
        try {
            service.createEstudiante(estudiante, token);
            return ResponseEntity.ok(estudiante);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/retirar")
    public ResponseEntity<String> retirarEstudiante(@RequestParam String documento, @RequestHeader("Authorization") String token) {
        try {
            return service.retirarEstudiante(documento, token);
        } catch (HttpClientErrorException.Unauthorized u) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
