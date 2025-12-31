package com.midia.sistema_notas.controllers.gestionacademica;

import com.midia.sistema_notas.dto.gestion_academicaDTO.MatriculaDTO;
import com.midia.sistema_notas.service.gestion_academicaService.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PutMapping("/promover")
    public ResponseEntity<String> promover() {
        try {
            service.promover();
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/retirar")
    public ResponseEntity<String> retirar(String numeroDocumento, @RequestHeader("Authorization") String token) {
        try {
            service.retirar(numeroDocumento, token);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
