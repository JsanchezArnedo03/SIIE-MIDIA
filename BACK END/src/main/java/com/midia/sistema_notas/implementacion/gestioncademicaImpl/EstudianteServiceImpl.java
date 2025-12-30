package com.midia.sistema_notas.implementacion.gestioncademicaImpl;

import com.midia.sistema_notas.config.JwtUtils;
import com.midia.sistema_notas.dto.gestion_academicaDTO.EstudianteDTO;
import com.midia.sistema_notas.entities.catalogos.CondicionFisica;
import com.midia.sistema_notas.entities.catalogos.CondicionPsicologica;
import com.midia.sistema_notas.entities.catalogos.Empresa;
import com.midia.sistema_notas.entities.catalogos.TipoDocumento;
import com.midia.sistema_notas.entities.gestion_academica.Estudiante;
import com.midia.sistema_notas.entities.seguridad.Rol;
import com.midia.sistema_notas.enums.EstadoEstudiante;
import com.midia.sistema_notas.repository.catalogos.CondicionFisicaRepository;
import com.midia.sistema_notas.repository.catalogos.CondicionPsicologicaRepository;
import com.midia.sistema_notas.repository.catalogos.EmpresaRepository;
import com.midia.sistema_notas.repository.catalogos.TipoDocumentoRepository;
import com.midia.sistema_notas.repository.gestion_academica.EstudianteRepository;
import com.midia.sistema_notas.repository.gestion_academica.RolRepository;
import com.midia.sistema_notas.service.gestion_academicaService.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteRepository repository;
    @Autowired
    private CondicionFisicaRepository condicionFisicaRepository;
    @Autowired
    private CondicionPsicologicaRepository condicionPsicologicaRepository;
    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;
    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private EmpresaRepository empresaRepository;
    @Autowired
    JwtUtils jwtUtils;

    @Override
    public ResponseEntity<Object> createEstudiante(EstudianteDTO estudiante, String token) {
        String jwt = token.startsWith("Bearer ") ? token.substring(7) : token;
        Long idEmpresa = jwtUtils.getEmpresaIdFromToken(jwt);
        if (estudiante == null) {
            return ResponseEntity.badRequest().body("Estudiante requerido");
        }
        Optional<Estudiante> existe = repository.findBynumeroDocumento(estudiante.getIdPersona().getNumeroDocumento());
        if (existe.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Estudiante existente");
        } else {
            //BUSQUEDA DE LAS ENTIDADES AÑADIDAS CONDICION FISICA, CONDICION PSICOLOGICA, TIPO DOCUMENTO
            Optional<CondicionFisica> condicionFisica = condicionFisicaRepository
                    .findByName(estudiante.getIdTipoCondicionFisica().getCondicionFisica());
            Optional<CondicionPsicologica> condicionPsicologica = condicionPsicologicaRepository
                    .findByName(estudiante.getIdTipoCondiconPsicologica().getCondicionPsicologica());
            Optional<TipoDocumento> tipoDocumento = tipoDocumentoRepository
                    .findByName(String.valueOf(estudiante.getIdPersona().getIdTipoDocumento()));
            Optional<Rol> rol = rolRepository.findById(estudiante.getIdPersona().getRol().getIdRol());
            Optional<Empresa> empresa = empresaRepository.findById(idEmpresa);
            Estudiante nuevoEstudiante = new Estudiante();
            nuevoEstudiante.setEstadoEstudiante(EstadoEstudiante.MATRICULADO);
            nuevoEstudiante.setIdTipoDocumento(tipoDocumento.get());
            nuevoEstudiante.setIdEmpresa(empresa.get());
            nuevoEstudiante.setNumeroDocumento(estudiante.getIdPersona().getNumeroDocumento());
            nuevoEstudiante.setPrimerNombre(estudiante.getIdPersona().getPrimerNombre());
            nuevoEstudiante.setSegundoNombre(estudiante.getIdPersona().getSegundoNombre());
            nuevoEstudiante.setPrimerApellido(estudiante.getIdPersona().getPrimerApellido());
            nuevoEstudiante.setSegundoApellido(estudiante.getIdPersona().getSegundoApellido());
            nuevoEstudiante.setFechaNacimiento(estudiante.getFechaNacimiento());
            nuevoEstudiante.setIdTipoCondicionFisica(condicionFisica.get());
            nuevoEstudiante.setIdTipoCondicionPsicologica(condicionPsicologica.get());
            nuevoEstudiante.setTelefono1(estudiante.getIdPersona().getTelefono1());
            nuevoEstudiante.setRol(rol.get());
            nuevoEstudiante.setEmail(estudiante.getIdPersona().getEmail());

            repository.save(nuevoEstudiante);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEstudiante);
        }
    }

    @Override
    public ResponseEntity<String> retirarEstudiante(String documento, String token) {
        String jwt = token.startsWith("Bearer ") ? token.substring(7) : token;
        Long idEmpresa = jwtUtils.getEmpresaIdFromToken(jwt);
        if (documento == null) {
            return ResponseEntity.badRequest().body("Documento requerido");
        }
        return repository.findBynumeroDocumento(documento)
                .map(estudiante ->
                {
                    if (estudiante.getEstadoEstudiante() == EstadoEstudiante.RETIRADO) {
                        return ResponseEntity.status(HttpStatus.CONFLICT).body("El estudiante no se encuentra matriculado en ninguna institucion");
                    }
                    if (!estudiante.getIdEmpresa().getIdEmpresa().equals(idEmpresa)) {
                        return ResponseEntity.status(HttpStatus.CONFLICT).body("No tiene permitido retirar este estudiante");
                    }
                    estudiante.setEstadoEstudiante(EstadoEstudiante.RETIRADO);
                    repository.save(estudiante);
                    return ResponseEntity.ok("El estudiante se retiro satisfactoriamente");
                }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudiante no encontrado con el documento: " + documento));
    }
}
