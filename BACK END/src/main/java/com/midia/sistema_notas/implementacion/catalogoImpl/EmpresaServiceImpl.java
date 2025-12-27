package com.midia.sistema_notas.implementacion.catalogoImpl;


import com.midia.sistema_notas.dto.catalogosDTO.EmpresaDTO;
import com.midia.sistema_notas.repository.catalogos.EmpresaRepository;
import com.midia.sistema_notas.service.catalogosService.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    EmpresaRepository repository;

    @Override
    public List<EmpresaDTO> findAll() {
        return repository.findAll().stream()
                .map(EmpresaDTO::toDTO) // Convertimos cada entidad a DTO
                .toList();
    }

    @Override
    public Optional<EmpresaDTO> findById(Long id) {

        return Optional.ofNullable(repository.findById(id)
                .map(EmpresaDTO::toDTO)
                .orElseThrow(() -> new RuntimeException("Empresa no encontrada")));

    }
}
