package com.midia.sistema_notas.controllers;

import com.midia.sistema_notas.dto.catalogosDTO.EmpresaDTO;
import com.midia.sistema_notas.service.catalogosService.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/findAll")
    public ResponseEntity<List<EmpresaDTO>> findAll() {
        try {
            service.findAll();
            return  ResponseEntity.ok(service.findAll());
        }catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<EmpresaDTO> saveEmpresa(@RequestBody EmpresaDTO empresaDTO) {
        try{
            service.create(empresaDTO);
            return ResponseEntity.ok().build();

        }catch (RuntimeException e) {
            return ResponseEntity.status( HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<EmpresaDTO> updateEmpresa(@RequestBody EmpresaDTO empresaDTO) {
        try{
            service.update(empresaDTO);
            return ResponseEntity.ok().build();

        }catch (RuntimeException e) {
            return ResponseEntity.status( HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/activate")
    public ResponseEntity<EmpresaDTO> activate(@RequestParam String nit) {
        try{
            service.activarEmpresa(nit);
            return ResponseEntity.ok().build();

        }catch (RuntimeException e) {
            return ResponseEntity.status( HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/inactivate")
    public ResponseEntity<EmpresaDTO> inactivate(@RequestParam String nit) {
        try{
            service.inactivarEmpresa(nit);
            return ResponseEntity.ok().build();

        }catch (RuntimeException e) {
            return ResponseEntity.status( HttpStatus.BAD_REQUEST).build();
        }
    }
    @PutMapping("/suspend")
    public ResponseEntity<EmpresaDTO> suspend(@RequestParam String nit) {
        try{
            service.suspenderEmpresa(nit);
            return ResponseEntity.ok().build();
        }catch (RuntimeException e) {
            return ResponseEntity.status( HttpStatus.BAD_REQUEST).build();
        }
    }

}

