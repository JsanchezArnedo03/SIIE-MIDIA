package com.midia.sistema_notas.controllers;

import com.midia.sistema_notas.dto.catalogosDTO.EmpresaDTO;
import com.midia.sistema_notas.service.catalogosService.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {

    @Autowired
    EmpresaService service;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<EmpresaDTO>> getEmpresa(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.findById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

