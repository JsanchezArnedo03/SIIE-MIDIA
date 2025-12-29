package com.midia.sistema_notas.implementacion.catalogoImpl;

import com.midia.sistema_notas.dto.catalogosDTO.TipoDocumentoDTO;
import com.midia.sistema_notas.repository.catalogos.TipoDocumentoRepository;
import com.midia.sistema_notas.service.catalogosService.TipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

    @Autowired
    TipoDocumentoRepository repository;


    @Override
    public List<TipoDocumentoDTO> findAll() {
        return repository.findAll().stream().map(TipoDocumentoDTO::toDTO).toList();
    }

    @Override
    public Optional<TipoDocumentoDTO> findByName(String name) {
        return repository.findByName(name)
                .map(TipoDocumentoDTO::toDTO);
    }
}
