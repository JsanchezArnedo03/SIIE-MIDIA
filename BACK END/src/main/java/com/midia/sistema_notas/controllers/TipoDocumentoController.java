package com.midia.sistema_notas.controllers;


import com.midia.sistema_notas.dto.catalogosDTO.TipoDocumentoDTO;
import com.midia.sistema_notas.service.catalogosService.TipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tipo-documento")
public class TipoDocumentoController {

    @Autowired
    TipoDocumentoService service;

    @GetMapping("/findAll")
    public ResponseEntity<List<TipoDocumentoDTO>> findAll() {
        try {
            return ResponseEntity.ok(service.findAll());
        } catch (RuntimeException r) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/findByName")
    public ResponseEntity<Optional<TipoDocumentoDTO>> findByName(String name) {
        try {
            return ResponseEntity.status(HttpStatus.FOUND).body(service.findByName(name));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
