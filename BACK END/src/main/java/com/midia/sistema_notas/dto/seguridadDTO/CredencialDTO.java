package com.midia.sistema_notas.dto.seguridadDTO;


import com.midia.sistema_notas.entities.gestion_academica.Persona;
import com.midia.sistema_notas.entities.seguridad.Credencial;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CredencialDTO {

    private Long id;
    private String username;
    private String password;
    private Persona persona;

    public CredencialDTO(){

    }
    public CredencialDTO(Credencial credencial){

    }
    public CredencialDTO toDTO(Credencial credencial){
        return new CredencialDTO(credencial);
    }
}
