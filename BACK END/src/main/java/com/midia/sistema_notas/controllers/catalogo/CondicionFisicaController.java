package com.midia.sistema_notas.controllers.catalogo;

import com.midia.sistema_notas.dto.catalogosDTO.CondicionFisicaDTO;
import com.midia.sistema_notas.service.catalogosService.CondicionFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/condicion-fisica")
public class CondicionFisicaController {


    @Autowired
    CondicionFisicaService service;

    @GetMapping("/findAll")
    public ResponseEntity<List<CondicionFisicaDTO>> findAll() {
        try {
            return ResponseEntity.ok(service.findAll());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findByName")
    public ResponseEntity<Optional<CondicionFisicaDTO>> findByName(@RequestParam String name) {
        try {
            return ResponseEntity.status(HttpStatus.FOUND).body(service.findByName(name));
        } catch (RuntimeException r) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CondicionFisicaDTO condicionFisicaDTO) {
        try {
            return ResponseEntity.ok(service.create(condicionFisicaDTO));
        } catch (RuntimeException r) {
            return ResponseEntity.badRequest().build();
        }
    }
}



