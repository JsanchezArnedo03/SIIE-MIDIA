package com.midia.sistema_notas.controllers;

import com.midia.sistema_notas.dto.gestion_academicaDTO.MatriculaDTO;
import com.midia.sistema_notas.service.gestion_academicaService.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matricula")
public class MatriculaController {

    @Autowired
    MatriculaService service;

    @PostMapping("/matricular")
    public ResponseEntity<String> matricular(@RequestBody MatriculaDTO matricula, @RequestHeader("Authorization") String token) {
        service.matricular(matricula, token);
        return ResponseEntity.ok("Matricula realizada con exito");
    }
}
