package com.midia.sistema_notas.controllers.catalogo;

import com.midia.sistema_notas.dto.catalogosDTO.CondicionPsicologicaDTO;
import com.midia.sistema_notas.service.catalogosService.CondicionPsicologicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/condicionPsicologica")
public class CondicionPsicologicaController {
    @Autowired
    CondicionPsicologicaService service;

    @GetMapping("/findAll")
    public ResponseEntity<List<CondicionPsicologicaDTO>> findAll() {
        try {
            return ResponseEntity.ok(service.findAll());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findByName")
    public ResponseEntity<Optional<CondicionPsicologicaDTO>> findByName(@RequestParam String name) {
        try {
            return ResponseEntity.status(HttpStatus.FOUND).body(service.findByName(name));
        } catch (RuntimeException r) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseEntity<CondicionPsicologicaDTO>> create(@RequestBody CondicionPsicologicaDTO condicionPsicologicaDTO) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.create(condicionPsicologicaDTO));
        } catch (RuntimeException r) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update")
    public boolean updateCondition(@RequestBody CondicionPsicologicaDTO condicionPsicologicaDTO) {
        try{
            return service.update(condicionPsicologicaDTO);
        }catch (RuntimeException r){
            return false;
        }
    }
}
