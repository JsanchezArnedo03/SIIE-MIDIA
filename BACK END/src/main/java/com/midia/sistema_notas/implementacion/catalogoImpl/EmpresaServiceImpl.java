package com.midia.sistema_notas.implementacion.catalogoImpl;


import com.midia.sistema_notas.dto.catalogosDTO.EmpresaDTO;
import com.midia.sistema_notas.entities.catalogos.Empresa;
import com.midia.sistema_notas.enums.EstadoEmpresa;
import com.midia.sistema_notas.repository.catalogos.EmpresaRepository;
import com.midia.sistema_notas.service.catalogosService.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return repository.findById(id)
                .map(EmpresaDTO::toDTO);
    }

    @Override
    public ResponseEntity<EmpresaDTO> create(EmpresaDTO empresaDTO) {
        return repository.findByNit(empresaDTO.getNit())
                .map(existente -> ResponseEntity.status(HttpStatus.CONFLICT).<EmpresaDTO>build())
                .orElseGet(() -> {
                    Empresa nuevaEmpresa = Empresa.toEntity(empresaDTO);
                    Empresa guardada = repository.save(nuevaEmpresa);
                    return ResponseEntity.status(HttpStatus.CREATED).body(EmpresaDTO.toDTO(guardada));
                });
    }

    @Override
    public ResponseEntity<EmpresaDTO> update(EmpresaDTO empresaDTO) {
        return repository.findByNit(empresaDTO.getNit()).map(
                existe -> {
                    existe.setDireccion(empresaDTO.getDireccion());
                    existe.setTelefono(empresaDTO.getTelefono());
                    existe.setEmail(empresaDTO.getEmail());
                    existe.setNombreComercial(empresaDTO.getNombreComercial());
                    Empresa actualizacion = repository.save(existe);
                    return ResponseEntity.ok().body(EmpresaDTO.toDTO(actualizacion));
                }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(empresaDTO));
    }

    @Override
    public boolean inactivarEmpresa(String nit) {
        return repository.findByNit(nit).map(
                existe -> {
                    existe.setEstado(EstadoEmpresa.INACTIVO);
                    repository.save(existe);
                    return true;
                }).orElse(false);
    }

    @Override
    public boolean activarEmpresa(String nit) {
        return repository.findByNit(nit).map(
                existe -> {
                    existe.setEstado(EstadoEmpresa.ACTIVO);
                    repository.save(existe);
                    return true;
                }).orElse(false);
    }

    @Override
    public boolean suspenderEmpresa(String nit) {
        return repository.findByNit(nit).map(
                existe -> {
                    existe.setEstado(EstadoEmpresa.SUSPENDIDA);
                    repository.save(existe);
                    return true;
                }).orElse(false);
    }
}
