package com.midia.sistema_notas.service.catalogosService;


import com.midia.sistema_notas.dto.catalogosDTO.EmpresaDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface EmpresaService {


    List<EmpresaDTO> findAll();

    Optional<EmpresaDTO> findById(Long id);

    ResponseEntity<EmpresaDTO> create(EmpresaDTO empresaDTO);

    ResponseEntity<EmpresaDTO> update(EmpresaDTO empresaDTO);

    boolean inactivarEmpresa(String nit);

    boolean activarEmpresa(String nit);

    boolean suspenderEmpresa(String nit);
}
