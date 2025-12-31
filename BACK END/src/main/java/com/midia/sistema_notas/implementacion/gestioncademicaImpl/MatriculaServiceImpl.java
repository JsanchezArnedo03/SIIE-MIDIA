package com.midia.sistema_notas.implementacion.gestioncademicaImpl;

import com.midia.sistema_notas.config.JwtUtils;
import com.midia.sistema_notas.dto.gestion_academicaDTO.MatriculaDTO;
import com.midia.sistema_notas.entities.catalogos.Empresa;
import com.midia.sistema_notas.entities.gestion_academica.Estudiante;
import com.midia.sistema_notas.entities.gestion_academica.Grado;
import com.midia.sistema_notas.entities.gestion_academica.Matricula;
import com.midia.sistema_notas.enums.EstadoEstudiante;
import com.midia.sistema_notas.repository.catalogos.EmpresaRepository;
import com.midia.sistema_notas.repository.gestion_academica.EstudianteRepository;
import com.midia.sistema_notas.repository.gestion_academica.GradoRepository;
import com.midia.sistema_notas.repository.gestion_academica.MatriculaRepository;
import com.midia.sistema_notas.service.gestion_academicaService.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;
    @Autowired
    private EstudianteRepository estudianteRepository;
    @Autowired
    private GradoRepository gradoRepository;
    @Autowired
    private EmpresaRepository empresaRepository;
    @Autowired
    JwtUtils jwtUtils;


    /*PENDIENTE POR PONERLE EL LISTENER PARA ESCUCHAR
    CUANDO SE REGISTRE UN NUEVO ESTUDIANTE EN EL SISTEMA
    GENERAR AUTOMÁTICAMENTE EL NUEVO REGISTRO EN LA MATRICULA
    */
    @Override
    public ResponseEntity<String> matricular(MatriculaDTO matriculaDTO, String token) {
        String jwt = token.startsWith("Bearer ") ? token.substring(7) : token;
        Long idEmpresa = jwtUtils.getEmpresaIdFromToken(jwt);

        if (matriculaDTO == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Matricula invalida");
        }
        Optional<Estudiante> estudiante = estudianteRepository
                .findBynumeroDocumento(matriculaDTO.getEstudiante()
                        .getIdPersona().getNumeroDocumento());
        Optional<Grado> grado = gradoRepository.
                findById(matriculaDTO.getGrado().getIdGrado());
        Optional<Empresa> empresa = empresaRepository
                .findById(idEmpresa);
        if (estudiante.isEmpty()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El estudiante no existe");
        } else {
            Matricula matricula = new Matricula();
            matricula.setEstudiante(estudiante.get());
            matricula.setEstadoEstudiante(EstadoEstudiante.MATRICULADO);
            matricula.setGrado(grado.get());
            matricula.setEmpresa(empresa.get());
            matriculaRepository.save(matricula);
            return ResponseEntity.status(HttpStatus.CREATED).body("Matricula registrada");
        }
    }


    @Override
    public ResponseEntity<String> promover() {
        List<Matricula> registrosActuales = matriculaRepository.findByGradoAndEstadoMatricula().stream().toList();
        for (Matricula promovido : registrosActuales) {
            if (promovido.getEstadoEstudiante().equals(EstadoEstudiante.PROMOVIDO)) {
                Optional<Grado> gradoSiguiente = Optional.ofNullable(
                        gradoRepository.findFirstByIdGradoGreaterThanOrderByIdGradoAsc(promovido.getGrado().getIdGrado())
                );
                if (gradoSiguiente.isEmpty()) {
                    promovido.setEstadoEstudiante(EstadoEstudiante.GRADUADO);
                    promovido.setObservaciones(promovido.getObservaciones());
                    matriculaRepository.save(promovido);
                } else {
                    Matricula nuevaMatricula = new Matricula();
                    nuevaMatricula.setEstudiante(promovido.getEstudiante());
                    nuevaMatricula.setEmpresa(promovido.getEmpresa()); // Heredamos la empresa para no perder el filtro multi-tenant
                    nuevaMatricula.setGrado(gradoSiguiente.get());
                    nuevaMatricula.setEstadoEstudiante(EstadoEstudiante.MATRICULADO);

                    matriculaRepository.save(nuevaMatricula);
                }
            }
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Proceso de promoción masiva finalizado");
    }


    @Override
    public ResponseEntity<String> retirar(String numeroDocumento, String token) {
        String jwt = token.startsWith("Bearer ") ? token.substring(7) : token;
        Long idEmpresa = jwtUtils.getEmpresaIdFromToken(jwt);

        if (numeroDocumento == null || numeroDocumento.isEmpty()) {
            return ResponseEntity.badRequest().body("El numero de documento es invalido");
        }

        return estudianteRepository.findBynumeroDocumento(numeroDocumento)
                .filter(estudiante -> estudiante.getIdEmpresa().equals(idEmpresa))
                .map(estudiante -> {
                    return Optional.ofNullable(matriculaRepository.findByIdEstudianteAndIdEmpresa(estudiante.getIdPersona(), idEmpresa))
                            .map(matricula -> {
                                matricula.setEstadoEstudiante(EstadoEstudiante.RETIRADO);
                                matriculaRepository.save(matricula);
                                return ResponseEntity.ok("Matricula cancelada");
                            })
                            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Matricula inexistente"));
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("El estudiante no existe o no pertenece a esta institución"));
    }
}
