package com.midia.sistema_notas.implementacion.seguridadImpl;

import com.midia.sistema_notas.config.JwtUtils;
import com.midia.sistema_notas.dto.seguridadDTO.AuthResponse;
import com.midia.sistema_notas.entities.seguridad.Credencial;
import com.midia.sistema_notas.repository.seguridad.CredencialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CredencialRepository usuarioRepository;
    @Autowired
    private JwtUtils jwtUtils;

    public AuthResponse login(Credencial loginRequest) {
        // 1. Autenticar (Valida user y password)
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        // 2. BUSCAR LA ENTIDAD (Tipo Credencial, no tipo Repository)
        Credencial usuario = usuarioRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // 3. Obtener el ID de la empresa desde la relación en la DB
        // Asegúrate que tu clase 'Credencial' tenga un 'getPersona().getEmpresa().getId()' o similar
        Long idEmpresa = usuario.getIdEmpresa().getIdEmpresa();

        // 4. Generar el Token con el ID inyectado
        String token = jwtUtils.generateToken((UserDetails) usuario, idEmpresa);

        return new AuthResponse(token, usuario.getUsername(), "Login exitoso");
    }
}