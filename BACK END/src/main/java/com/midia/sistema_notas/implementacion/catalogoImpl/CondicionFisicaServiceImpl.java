package com.midia.sistema_notas.implementacion.catalogoImpl;

import com.midia.sistema_notas.dto.catalogosDTO.CondicionFisicaDTO;
import com.midia.sistema_notas.entities.catalogos.CondicionFisica;
import com.midia.sistema_notas.repository.catalogos.CondicionFisicaRepository;
import com.midia.sistema_notas.service.catalogosService.CondicionFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CondicionFisicaServiceImpl implements CondicionFisicaService {

    @Autowired
    CondicionFisicaRepository repository;

    @Override
    public List<CondicionFisicaDTO> findAll() {
        return repository.findAll().stream().map(CondicionFisicaDTO::toDTO).toList();
    }

    @Override
    public ResponseEntity<CondicionFisicaDTO> create(CondicionFisicaDTO condicionFisicaDTO) {
        return repository.findByName(condicionFisicaDTO.getCondicionFisica()) // 1. Corregido el cierre del paréntesis
                .map(existente -> ResponseEntity.status(HttpStatus.CONFLICT).<CondicionFisicaDTO>build()) // 2. Genérico correcto
                .orElseGet(() -> {
                    CondicionFisica nuevaCondicion = CondicionFisica.toEntity(condicionFisicaDTO);
                    CondicionFisica guardada = repository.save(nuevaCondicion);
                    return ResponseEntity.status(HttpStatus.CREATED).body(CondicionFisicaDTO.toDTO(guardada));
                });
    }

    @Override
    public Optional<CondicionFisicaDTO> findByName(String name) {
        return repository.findByName(name)
                .map(CondicionFisicaDTO::toDTO);
    }
}

