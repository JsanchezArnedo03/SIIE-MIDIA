package com.midia.sistema_notas.implementacion.catalogoImpl;


import com.midia.sistema_notas.dto.catalogosDTO.CondicionPsicologicaDTO;
import com.midia.sistema_notas.entities.catalogos.CondicionPsicologica;
import com.midia.sistema_notas.repository.catalogos.CondicionPsicologicaRepository;
import com.midia.sistema_notas.service.catalogosService.CondicionPsicologicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CondicionPsicologicaServiceImpl implements CondicionPsicologicaService {

    @Autowired
    CondicionPsicologicaRepository repository;

    @Override
    public List<CondicionPsicologicaDTO> findAll() {
        return repository.findAll().stream().map(CondicionPsicologicaDTO::toDTO).toList();
    }

    @Override
    public ResponseEntity<CondicionPsicologicaDTO> create(CondicionPsicologicaDTO condicionPsicologicaDTO) {
        return repository.findByName(condicionPsicologicaDTO.getCondicionPsicologica())
                .map(existente -> ResponseEntity.status(HttpStatus.CONFLICT).<CondicionPsicologicaDTO>build()) // 2. Genérico correcto
                .orElseGet(() -> {
                    CondicionPsicologica nuevaCondicion = CondicionPsicologica.toEntity(condicionPsicologicaDTO);
                    CondicionPsicologica guardada = repository.save(nuevaCondicion);
                    return ResponseEntity.status(HttpStatus.CREATED).body(CondicionPsicologicaDTO.toDTO(guardada));
                });
    }

    @Override
    public Optional<CondicionPsicologicaDTO> findByName(String name) {
        return repository.findByName(name)
                .map(CondicionPsicologicaDTO::toDTO);
    }

    @Override
    public boolean update(CondicionPsicologicaDTO condicionPsicologicaDTO) {
        return repository.findByName(condicionPsicologicaDTO.getCondicionPsicologica())
                .map(existe -> {
                    existe.setCondicionPsicologica(condicionPsicologicaDTO.getCondicionPsicologica());
                    existe.setDescripcion(condicionPsicologicaDTO.getDescripcion());
                    CondicionPsicologica guardada = repository.save(existe);
                    return true;
                }).orElse(false);
    }


}
